import java.util.ArrayList;
import java.util.List;

public class Promocion {

    private String descripcion;
    private float porcentajeDescuento; // Porcentaje de descuento aplicado a las facturas
    private List<Factura> facturaList; // Asociación 0..* con Factura

    // Constructor
    public Promocion(String descripcion, float porcentajeDescuento) {
        this.descripcion = descripcion;
        this.porcentajeDescuento = porcentajeDescuento;
        this.facturaList = new ArrayList<>();
    }

    // Getters y Setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(float porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    // Métodos para gestionar la asociación
    public void agregarFactura(Factura factura) {
        facturaList.add(factura);
    }

    public void eliminarFactura(Factura factura) {
        facturaList.remove(factura);
    }

    // Método para aplicar la promoción a todas las facturas asociadas
    public void aplicarPromocion() {
        for (Factura factura : facturaList) {
            float nuevoDescuento = factura.getDescuento() + porcentajeDescuento;
            factura.setDescuento(nuevoDescuento); // Aumenta el descuento de la factura
            factura.agregarItemFactura(new ItemFactura(1, new Producto("Promoción aplicada", 0, descripcion))); // Detalle extra
        }
    }
}
