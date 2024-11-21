public class ItemFactura {

    private float subtotal;
    private int cantidad;
    private Producto producto; //Relacion con Producto

    //Constructor
    public ItemFactura(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.subtotal = calcularSubtotal();//Calcula el subtotal al crear el ItemFactura
    }

    //Getters y Setters
    public float getSubtotal() {
        return subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.subtotal = calcularSubtotal();//Actualiza el subtotal
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        this.subtotal = calcularSubtotal(); //Actualiza el subtotal si cambia el producto
    }

    //Metodos
    public float calcularSubtotal() {
        return cantidad * producto.getPrecio();
    }
}


