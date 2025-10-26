package lab1ej5.Carro;

import java.util.HashSet;

/*********************************** Carro ******************************** /**
 * @brief Clase Carro
 *****************************************************************************/
public class Carro {
    /************************************************************************** /**
     * Declaracion de variables
     *****************************************************************************/
    private HashSet<Cliente> clientes; ///< Conjunto de clientes del carro

    /************************************************************************** /**
     * @brief Constructor de Carro
     *****************************************************************************/
    public Carro(){
        clientes = new HashSet<Cliente>();
    }

    /************************************** add() ***************************** /**
     * @brief Funcion para añadir los clientes al carro
     * 
     * @param c (Cliente) El cliente especifico a añadir
     * 
     * @return (Boolean) Resultado de la operacion
     *****************************************************************************/
    public boolean add(Cliente c){
        return clientes.add(c);
    }

    /********************************** toString() **************************** /**
     * @brief Determina la representacion en cadena del carro
     * 
     * @return (String) Representacion de la cadena del carro
     *****************************************************************************/
    public String toString(){
        String resultado = "";
        String resultadoC = "";
        for(Cliente c:clientes)
            resultadoC = resultadoC + c.toString() + "\n";
        resultado = resultado + resultadoC;
        return resultado;
    }
}