/**
 *
 * @author Natalia
 */
package ARCtrabajo;

import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.concurrent.*;

public class Cliente {

    public static void main(String[] args) throws Exception {
        //Primero, se conecta al servidor para obtener N, V y S
        Socket configSocket = new Socket("127.0.0.1", 9000);
        BufferedReader in = new BufferedReader(new InputStreamReader(configSocket.getInputStream()));
        String line = in.readLine();  //"CONFIG N V S"
        String[] p = line.split(" ");
        int N = Integer.parseInt(p[1]);
        int V = Integer.parseInt(p[2]);
        int S = Integer.parseInt(p[3]);
        System.out.printf("[Coordinador] Recibido N=%d, V=%d, S=%d%n", N, V, S);
        configSocket.close();

        //Crear N hilos de clientes
        ExecutorService pool = Executors.newFixedThreadPool(N);

        for (int i = 0; i < N; i++) {
            final int id = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    ejecutarCliente(id, N, V, S);
                }
            });
            Thread.sleep(50); //Pequeña pausa para no saturar
        }
        pool.shutdown();
        System.out.printf("Todos los clientes han terminado \n"); 
    }

    //Un cliente
    private static void ejecutarCliente(int id, int N, int V, int S) {
        try (Socket socket = new Socket("127.0.0.1", 9000)) {
            BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Random rand = new Random(id);

            int grupo = id / V;
            //Cliente se ha conectado
            
            //Esperar START del servidor
            String msg;
            do {
                msg = in.readLine();
            }while (msg != null && !msg.equals("START"));
            
            //Comienza la simulación

            //Hilo oyente (recibe mensajes del servidor)
            Thread listener = new Thread(() -> {
                try {
                    String line2;
                    while ((line2 = in.readLine()) != null) {
                        if (line2.startsWith("MSG")) {
                            String[] p2 = line2.split(" ");
                            int idOrigen = Integer.parseInt(p2[2]);
                            int iter = Integer.parseInt(p2[p2.length - 1]);
                            out.write("REPLY " + idOrigen + " " + iter + "\n");
                            out.flush();
                            //System.out.printf("[Cliente %d] Recibido MSG de %d REPLY enviado%n", id, idOrigen);
                        } else if (line2.startsWith("ACK")) {
                            synchronized (Cliente.class) {
                                Cliente.class.notifyAll();
                            }
                        }
                    }
                } catch (IOException e) {
                }
            });
            
            listener.start();

            //Enviar S veces las coordenadas y medir tiempos
            double totalTiempo = 0;

            for (int iter = 1; iter <= S; iter++){
                double x = rand.nextDouble() * 100.0;
                double y = rand.nextDouble() * 100.0;
                double z = rand.nextDouble() * 100.0;

                String coordMsg = "COORD " + id + " " + x + " " + y + " " + z + " " + iter;

                long inicio = System.nanoTime();
                out.write(coordMsg + "\n");
                out.flush();

                //Ha enviado las coordenadas al servidor
                
                synchronized (Cliente.class) {
                    Cliente.class.wait();
                }

                long fin = System.nanoTime();
                double duracionMs = (fin - inicio) / 1_000_000.0;
                totalTiempo += duracionMs;
                
                //Termina la iteración si quedan más vuelve al for
            }

            double media = totalTiempo / S;
            System.out.printf("[Cliente %d] Media de tiempo = %.3f ms%n", id, media);

            //Enviar media al servidor
            out.write("MEDIA " + id + " " + grupo + " " + media + "\n");
            out.flush();
            
            //Ya ha terminado las iteraciones y la media

        } catch (IOException | InterruptedException e) {
            System.err.println("[Cliente " + id + "] Error: " + e.getMessage());
        }
    }
}
