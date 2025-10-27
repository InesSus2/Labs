package lab1ej5.Carro;

/********************************* Producto ******************************* /**
 * @brief Clase Producto
 *****************************************************************************/
public class Producto {
    /************************************************************************** /**
     * Declaracion de variables
     *****************************************************************************/
    private static int proximo_prod_id = 1; ///< Contador global de productos
    private String prod_id; ///< Identificador del producto
    private String prod_descr; ///< Descripcion del producto
    private int cant; ///< Cantidad del producto
    private float precio; ///< Precio del producto

    /******************************** Producto() ****************************** /**
     * @brief Constructor de Producto
     * 
     * @param id_cli (String) Identificador del cliente
     * @param prod_descr (String) Descripcion del producto
     * @param cant (int) Cantidad del producto
     * @param precio (float) Precio del producto
     *****************************************************************************/
    public Producto(String id_cli, String prod_descr, int cant, float precio){
        this.prod_descr = prod_descr;
        this.cant = cant;
        this.precio = precio;
        this.prod_id = id_cli + String.format("%04d", proximo_prod_id);
        proximo_prod_id++;
    }

    /****************************** getProd_descr() *************************** /**
     * @brief Devuelve la descripcion del producto
     * 
     * @rturn prod_descr (Stirng) Descripcion del producto
     *****************************************************************************/
    public String getProd_descr(){
        return prod_descr;
    }

    /****************************** setProd_descr() *************************** /**
     * @brief Asigna la descripcion del producto
     * 
     * @param prod_descr (String) Descripcion del producto
     *****************************************************************************/
    public void setProd_descr(String prod_descr){
        this.prod_descr = prod_descr;
    }

    /********************************* getCant() ****************************** /**
     * @brief Devuelve la cantidad del producto
     * 
     * @rturn cant (int) Cantidad del producto
     *****************************************************************************/
    public int getCant(){
        return cant;
    }

    /********************************* setCant() ****************************** /**
     * @brief Asigna la cantidad del producto
     * 
     * @param cant (int) Cantidad del producto
     *****************************************************************************/
    public void setCant(int cant){
        this.cant = cant;
    }

    /********************************* getPrecio() **************************** /**
     * @brief Devuelve el precio del producto
     * 
     * @rturn precio (float) Precio del producto
     *****************************************************************************/
    public float getPrecio(){
        return precio;
    }

    /********************************* setPrecio() **************************** /**
     * @brief Asigna el precio del producto
     * 
     * @param precio (float) Precio del producto
     *****************************************************************************/
    public void setPrecio(float precio){
        this.precio = precio;
    }

    /********************************** toString() **************************** /**
     * @brief Determina la representacion en cadena del producto
     * 
     * @return (String) Representacion de la cadena del producto
     *****************************************************************************/
    public String toString(){
        return "\n" + "ID Producto: " + prod_id + "\n" + "Descripción: " + prod_descr + "\n" + "Cantidad: " + cant + "\n" + "Precio: " + precio + "\n";
    }
}