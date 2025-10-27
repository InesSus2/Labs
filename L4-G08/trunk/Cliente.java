package lab1ej5.Carro;

import java.util.HashSet;

/********************************* Cliente ******************************** /**
 * @brief Clase Cliente
 *****************************************************************************/
public class Cliente {
    /************************************************************************** /**
     * Declaracion de variables
     *****************************************************************************/
    private static int proximo_cli_id = 0; ///< Contador global de clientes
    private String cli_id; ///< Identificador del cliente
    private String cli_nombre; ///< Nombre del cliente
    private String cli_dir; ///< Dirección del cliente
    private Boolean cli_activo; ///< Estado activo/no activo del cliente
    private HashSet<Producto> productos; ///< Conjunto de productos del cliente

    /******************************** Cliente() ******************************* /**
     * @brief Constructor de Cliente
     * 
     * @param cli_nombre (String) Nombre del cliente
     * @param cli_dir (String) Dirección del cliente
     * @param cli_activo (Boolean) Estado del cliente
     *****************************************************************************/
    public Cliente(String cli_nombre, String cli_dir, Boolean cli_activo){
        this.cli_nombre = cli_nombre;
        this.cli_dir = cli_dir;
        this.cli_activo = cli_activo;
        productos = new HashSet<Producto>();
        this.cli_id = String.format("%03d", proximo_cli_id);
        proximo_cli_id++;
    }

    /******************************** getCli_id() ***************************** /**
     * @brief Devuelve el ID del cliente
     * 
     * @rturn cli_id (String) ID del cliente
     *****************************************************************************/
    public String getCli_id(){
        return cli_id;
    }

    /****************************** getCli_nombre() *************************** /**
     * @brief Devuelve el nombre del cliente
     * 
     * @rturn cli_nombre (String) Nombre del cliente
     *****************************************************************************/
    public String getCli_nombre(){
        return cli_nombre;
    }

    /****************************** setCli_nombre() *************************** /**
     * @brief Asigna el nombre del cliente
     * 
     * @param cli_nombre (String) Nombre del cliente
     *****************************************************************************/
    public void setCli_nombre(String cli_nombre){
        this.cli_nombre = cli_nombre;
    }

    /******************************** getCli_dir() **************************** /**
     * @brief Devuelve la direccion del cliente
     * 
     * @return cli_dir (String) Direccion del cliente
     *****************************************************************************/
    public String getCli_dir(){
        return cli_dir;
    }

    /******************************** setCli_dir() **************************** /**
     * @brief Asigna la direccion del cliente
     * 
     * @param cli_dir (String) Direccion del cliente
     *****************************************************************************/
    public void setCli_dir(String cli_dir){
        this.cli_dir = cli_dir;
    }

    /******************************** getCli_activo() ************************* /**
     * @brief Devuelve si el cliente esta o no activo
     * 
     * @return cli_activo (Boolean) Cliente activo/ no activo
     *****************************************************************************/
    public Boolean getCli_activo(){
        return cli_activo;
    }

    /******************************** setCli_activo() ************************* /**
     * @brief Asigna si el cliente esta o no activo
     * 
     * @param cli_activo (Boolean) Cliente activo/ no activo
     *****************************************************************************/
    public void setCli_activo(Boolean cli_activo){
        this.cli_activo = cli_activo;
    }

    /************************************** add() ***************************** /**
     * @brief Funcion para añadir los productos al cliente en particular
     * 
     * @param p (Producto) El producto especifico a añadir
     * 
     * @return (Boolean) Resultado de la operacion
     *****************************************************************************/
    public boolean add(Producto p){
        return productos.add(p);
    }
    
    /********************************** toString() **************************** /**
     * @brief Determina la representacion en cadena del cliente
     * 
     * @return (String) Representacion de la cadena del cliente
     *****************************************************************************/
    public String toString(){
        String resultado = "";
        for(Producto p:productos)
            resultado = resultado + p.toString() + "\n";
        return "ID Cliente: " + cli_id + "\n" + "Nombre: " + cli_nombre + "\n" + "Dirección: " + cli_dir + "\n" + "Activo: " + cli_activo + "\n" + resultado;
    }
}