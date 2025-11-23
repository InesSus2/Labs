package ARCtrabajo;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class Servidor {

    //Pedir variables
    private static int N; // número de clientes
    private static int V; // número de vecinos (divisor de N)
    private static int S; // número de simulaciones
    private static final List<Socket> clientes = new CopyOnWriteArrayList<>();
    private static final Map<String, Integer> pendientes = new ConcurrentHashMap<>();
    private static final Map<Integer, Double> mediasClientes = new ConcurrentHashMap<>();

    public static void main(String[] args) throws Exception{
        //Primero el servidor pregunta al usuario N, V y S.
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de clientes (N): ");
        N = sc.nextInt();
        System.out.print("Número de vecinos (divisor de N): ");
        V = sc.nextInt();
        System.out.print("Número de simulaciones (S): ");
        S = sc.nextInt();

        if (N % V != 0) {
            System.out.println("Error: V debe ser divisor de N.");
            return;
        }

        System.out.println("[Servidor] Esperando " + N + " clientes...");
        //Crea un socket de servidor TCP en el puerto 9000
        ServerSocket serverSocket = new ServerSocket(9000);

        boolean configEnviada = false; //Para detectar si ya le ha enviado N, V y S.
        while (clientes.size() < N) {
            //Crea un socketpara conectarse con el cliente
             //Cada cliente se va conectando
            Socket socket = serverSocket.accept();
            //Este if sirve para enviar los datos que ha insertado el usuario a los clientes
            if (!configEnviada) {
                //Función enviarMensaje local
                enviarMensaje(socket, "CONFIG " + N + " " + V + " " + S);
                System.out.println("[Servidor] Enviada configuracion inicial.");
                socket.close(); //Este socket se debe cerrar porque solo se usa para enviar esta informacio
                configEnviada = true;
                continue;
            }
            //Clientes es una lista donde se le añade cada socket creado por el cliente
            clientes.add(socket);
        }

        //Se inicia la simulación
        broadcast("START"); //Función auxiliar que envia una señal a todos los clientes conectados al servidor de que pueden comenzar la simulación
        System.out.println("[Servidor] Todos los clientes conectados. Iniciando simulacion...");

        //Crear hilos manejadores
        //Cada vez que un cliente se conecta, el Servidor crea un hilo.
        for (int i = 0; i < clientes.size(); i++) {
            Socket s = clientes.get(i);
            Thread t = new Thread(new ManejadorCliente(s, i)); //Cada cliente conectado tiene su propio hilo ManejadorCliente escuchando lo que el cliente envía.
            t.start();
        }
    }

    //MANEJADOR DE CLIENTE
    //Cada cliente conectado tiene su propio hilo ManejadorCliente escuchando lo que el cliente envía.
    //Se declara una clase interna estática llamada ManejadorCliente que implementa la interfaz Runnable.
    //Es estática porque no necesita una instancia de Servidor para existir.
    static class ManejadorCliente implements Runnable{
        private final Socket socket;
        private final int id;

        ManejadorCliente(Socket socket, int id){
            this.socket = socket;
            this.id = id;
        }

        @Override
        public void run(){
            //Se crea un lector de texto (BufferedReader) sobre el flujo de entrada (InputStream) del socket.
            //Esto permite leer las líneas de texto que el cliente envía, con readLine().
            //El try (...) hace que Java cierre el BufferedReader automáticamente al final, evitando fugas de memoria o sockets abiertos.
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
                String line;
                while ((line = in.readLine()) != null) {
                    procesarMensaje(id, line);
                }
            } catch (IOException e) {
                System.out.println("[Servidor] Cliente " + id + " desconectado.");
            }
        }
    }

    //Funciones auxiliares
    //Funcion enviarMensaje para simplificar código
    private static void enviarMensaje(Socket s, String msg){
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bw.write(msg + "\n");
            bw.flush();
        } catch (IOException e) {
            System.err.println("[Servidor] Error al enviar mensaje a cliente.");
        }
    }
    //Enviar mensaje a todos los clientes conectados
    private static void broadcast(String msg) {
        for (Socket s : clientes) enviarMensaje(s, msg);
    }

    //Procesar mensajes: 
    private static void procesarMensaje(int id, String msg) {
        String[] parts = msg.split(" ");
        String tipo = parts[0];

        if (tipo.equals("COORD")) {
            
            //guardar el numero de iteracion
            int iter = Integer.parseInt(parts[5]);

            String key = id + "_" + iter;
            pendientes.put(key, V - 1);
            //La coordenada ha sido recibida
            
            
            //Tras recibir la coordenada se la tiene que enviar a sus vecinos para ellos necesita el id y el mensaje 
            reenviarAVecinos(id, msg);
        }

        else if (tipo.equals("REPLY")) {
            int idOrigen = Integer.parseInt(parts[1]);
            int iter = Integer.parseInt(parts[2]);
            String key = idOrigen + "_" + iter;

            pendientes.computeIfPresent(key, (k, v) -> v - 1);
            int restantes = pendientes.getOrDefault(key, 0);
            if (restantes <= 0) {
                pendientes.remove(key);
                enviarMensaje(clientes.get(idOrigen), "ACK " + iter);
                //System.out.println("[Servidor] ACK enviado al cliente " + idOrigen + " (iter " + iter + ")");
            }
        }

        else if (tipo.equals("MEDIA")) {
            int idCliente = Integer.parseInt(parts[1]);
            int grupo = Integer.parseInt(parts[2]);
            double media = Double.parseDouble(parts[3]);
            mediasClientes.put(idCliente, media);
            //System.out.printf("[Servidor] MEDIA recibida de cliente %d (grupo %d) = %.3f ms%n",
            //      idCliente, grupo, media);

            if (mediasClientes.size() == clientes.size()) {
                System.out.println("\n RESULTADOS: ");
                calcularMediasFinales();
            }
        }
    }

    //Funcion para enviar las coordenadas a los vecinos
    private static void reenviarAVecinos(int id, String msg) {
        int grupo = id / V;
        int inicio = grupo * V;
        int fin = inicio + V;

        for (int i = inicio; i < fin && i < clientes.size(); i++) {
            if (i == id) continue;
            //Utiliza la función para enviar un ACK al servidor
            enviarMensaje(clientes.get(i), "MSG " + msg);
        }
    }

    //CALCULAR MEDIAS FINALES
    private static void calcularMediasFinales() {
        
        Map<Integer, List<Double>> grupos = new HashMap<>();

        for (Map.Entry<Integer, Double> entry : mediasClientes.entrySet()) {
            int id = entry.getKey();
            double media = entry.getValue();
            int grupo = id / V;
            grupos.putIfAbsent(grupo, new ArrayList<>());
            grupos.get(grupo).add(media);
        }

        double total = 0;
        int count = 0;

            for (Map.Entry<Integer, List<Double>> entry : grupos.entrySet()) {
        int grupo = entry.getKey();
        List<Double> medias = entry.getValue();
        double mediaGrupo = medias.stream().mapToDouble(Double::doubleValue).average().orElse(0);

        System.out.printf("Grupo " + grupo + " tiempo medio = %.3f ms%n", mediaGrupo);

        total += mediaGrupo;
        count++;
    }


        double mediaTotal = total / count;
        System.out.printf("Tiempo medio global del sistema = %.3f ms%n", mediaTotal);
    }
}
