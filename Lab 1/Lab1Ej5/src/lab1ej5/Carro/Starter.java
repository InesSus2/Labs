package lab1ej5.Carro;

import javax.swing.JOptionPane;

/************************************************************************** /**
 * @author Inés Jaso Pernod
 * @author Natalia Tauste Rubio
 * @brief Practica 1 EU - Ejercicio 5
 * 
 * @version 1.0
 * @date 17/10/2025
 *****************************************************************************/

/********************************* Starter ******************************** /**
 * @brief Clase Starter (Main del programa)
 *****************************************************************************/
public class Starter {
    /************************************************************************** /**
     * @brief Funcion principal
     * 
     * @param argv Argumentos de entrada
     *****************************************************************************/
    public static void main(String[] argv){
        /************************************************************************** /**
         * Declaracion de variables
         *****************************************************************************/
        String cli_nombre; ///< Nombre del cliente
        String cli_dir; ///< Dirección del cliente
        String prod_descr; ///< Descripcion del producto
        Boolean cli_activo; ///< Estado del cliente
        int cant; ///< Cantidad del producto
        float precio; ///< Precio del producto
        float precio_tot = 0; ///< Precio total del producto
        int continuar; ///< Variable para continuar introduciendo clientes
        int continuarP; ///< Variable para continuar introduciendo productos
        Carro carro = new Carro(); ///< Carro de la compra

        do{
            /************************************************************************** /**
             * Introduccion de datos de los clientes
             *****************************************************************************/
            cli_nombre = JOptionPane.showInputDialog(null, "Introduce el NOMBRE del cliente");
            cli_dir = JOptionPane.showInputDialog(null, "Introduce la DIRECCIÓN del cliente");
            cli_activo = JOptionPane.showConfirmDialog(null, "El cliente esta ACTIVO?", "Seleccione la opcion deseada", JOptionPane.YES_NO_OPTION) == 0;
            
            Cliente cli = new Cliente(cli_nombre, cli_dir, cli_activo);
            /************************************************************************** /**
             * Se añade el cliente al carro
             *****************************************************************************/
            carro.add(cli);

            do{
                /************************************************************************** /**
                 * Introduccion de datos de los productos
                 *****************************************************************************/
                prod_descr = JOptionPane.showInputDialog(null, "Introduce la DESCRIPCIÓN del producto");
                try{
                    cant = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la CANTIDAD del producto"));
                } catch (NumberFormatException e){cant = 0;}
                try{
                    precio = Float.parseFloat(JOptionPane.showInputDialog(null, "Introduce el PRECIO del producto"));
                } catch (NumberFormatException e){precio = 0;}

                precio_tot = 0;
                precio_tot = precio_tot + (cant * precio);

                continuarP = JOptionPane.showConfirmDialog(null, "Quieres introducir más productos?", "Seleccione la opcion deseada", JOptionPane.YES_NO_OPTION);

                /************************************************************************** /**
                 * Se añade el producto al cliente
                 *****************************************************************************/
                cli.add(new Producto(cli.getCli_id(), prod_descr, cant, precio_tot));
            }
            while(continuarP == 0);

            continuar = JOptionPane.showConfirmDialog(null, "Quieres introducir más clientes?", "Seleccione la opcion deseada", JOptionPane.YES_NO_OPTION);
        }
        while (continuar == 0);

        JOptionPane.showMessageDialog(null, carro);
        System.out.println(carro);
    }
}