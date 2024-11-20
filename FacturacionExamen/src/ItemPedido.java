import java.util.ArrayList;
import java.util.List;

public class ItemPedido {

    private float precioUnitario;
    private String descripcion;
    private List<Producto> productoList; // Relación 1 a N con Producto

    //Constructor
    public ItemPedido(float precioUnitario, String descripcion) {
        this.precioUnitario = precioUnitario;
        this.descripcion = descripcion;
        this.productoList = new ArrayList<>();
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

    public List<Producto> getProductoList() {
        return productoList;
    }

    //Metodos para gestionar la lista de productos
    public void agregarProducto(Producto producto) {
        productoList.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        productoList.remove(producto);
    }

    public void mostrarProductos() {
        System.out.println("Productos en el ItemPedido (" + descripcion + "):");
        for (Producto producto : productoList) {
            System.out.println("  - " + producto.getNombre() + ": $" + producto.getPrecio());
        }
    }

    //Metodo adicional
    public String obtenerDescripcion() {
        return descripcion;
    }
}

