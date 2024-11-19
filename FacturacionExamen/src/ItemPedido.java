public class ItemPedido {

    private float precioUnitario;
    private String descripcion;

    //Constructor
    public ItemPedido(float precioUnitario, String descripcion) {
        this.precioUnitario = precioUnitario;
        this.descripcion = descripcion;
    }

    //Getters y Setters
    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //Metodo
    public String obtenerDescripcion() {
        return descripcion;
    }
}
