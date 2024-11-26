import java.util.ArrayList;
import java.util.List;

public class ItemFactura {

    private float subtotal;
    private int cantidad;
    private List<Producto> productos;//Relacion N a N con Producto

    //Constructor
    public ItemFactura(int cantidad) {
        this.cantidad = cantidad;
        this.productos = new ArrayList<>();
        this.subtotal = 0;
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
        this.subtotal = calcularSubtotal();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
        this.subtotal = calcularSubtotal();
    }

    //metodos
    public void agregarProducto(Producto producto) {
        if (!productos.contains(producto)) {
            productos.add(producto);
            producto.agregarItemFactura(this);
            this.subtotal = calcularSubtotal();
        }
    }

    public void eliminarProducto(Producto producto) {
        if (productos.contains(producto)) {
            productos.remove(producto);
            producto.eliminarItemFactura(this);
            this.subtotal = calcularSubtotal();
        }
    }

    public float calcularSubtotal() {
        float subtotalTemp = 0;
        for (Producto producto : productos) {
            subtotalTemp += cantidad * producto.getPrecio();
        }
        return subtotalTemp;
    }

    public void actualizarSubtotal() {
        this.subtotal = calcularSubtotal();
    }
}
