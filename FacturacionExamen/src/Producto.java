import java.util.ArrayList;
import java.util.List;

public class Producto {

    private String nombre;
    private float precio;
    private String descripcion;
    private List<ItemFactura> itemFacturaList;//Relacion 1 a N con ItemFactura

    //Constructor
    public Producto(String nombre, float precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.itemFacturaList = new ArrayList<>();
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<ItemFactura> getItemFacturaList() {
        return itemFacturaList;
    }

    //Metodos para gestionar la lista de ItemFactura
    public void agregarItemFactura(ItemFactura itemFactura) {
        itemFacturaList.add(itemFactura);
    }

    public void eliminarItemFactura(ItemFactura itemFactura) {
        itemFacturaList.remove(itemFactura);
    }

    public void mostrarItemsFactura() {
        System.out.println("Items asociados al Producto (" + nombre + "):");
        for (ItemFactura item : itemFacturaList) {
            System.out.println("  - Cantidad: " + item.getCantidad() + ", Subtotal: $" + item.getSubtotal());
        }
    }

    //Metodo para actualizar el precio
    public float actualizarPrecio(float nuevoPrecio) {
        this.precio = nuevoPrecio;
        return this.precio;
    }
}

