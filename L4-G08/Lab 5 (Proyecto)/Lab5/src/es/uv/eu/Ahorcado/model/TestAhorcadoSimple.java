package Ahorcado.model;

// TestAhorcadoSimple.java
import Ahorcado.model.AhorcadoModel;

public class TestAhorcadoSimple {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DEL AHORCADO ===");
        
        // Crear modelo con una palabra
        AhorcadoModel modelo = new AhorcadoModel("PROGRAMACION");
        
        System.out.println("Palabra secreta: PROGRAMACION");
        System.out.println("Probando con Estilo 1...");
        
        // Probar letras incorrectas para ver imágenes de fallo
        char[] letrasIncorrectas = {'X', 'Y', 'Z', 'W', 'K', 'Q'};
        
        for (char letra : letrasIncorrectas) {
            System.out.println("\nProbando letra: " + letra);
            boolean resultado = modelo.probarLetraEstilo1(letra);
            System.out.println("Resultado: " + (resultado ? "Correcta" : "Incorrecta"));
            System.out.println("Fallos actuales: " + modelo.getFallos());
            
            if (modelo.getImagenAhorcado() != null) {
                System.out.println("Imagen cargada: Sí");
            } else {
                System.out.println("Imagen cargada: No");
            }
            
            // Pausa para ver
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
        
        System.out.println("\n=== PRUEBA COMPLETADA ===");
    }
}