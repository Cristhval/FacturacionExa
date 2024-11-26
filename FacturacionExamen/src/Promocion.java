import java.util.ArrayList;
import java.util.List;

public class Promocion {

    private String descripcion;
    private float porcentajeDescuento;//Porcentaje de descuento aplicado a las facturas
    private List<Factura> facturaList;//Asociacion con Factura

    //Constructor
    public Promocion(String descripcion, float porcentajeDescuento) {
        this.descripcion = descripcion;
        this.porcentajeDescuento = porcentajeDescuento;
        this.facturaList = new ArrayList<>();
    }

    //Getters y Setters
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

    //metodos para gestionar la asociacion
    public void agregarFactura(Factura factura) {
        facturaList.add(factura);
    }

    public void eliminarFactura(Factura factura) {
        facturaList.remove(factura);
    }

    //metodo para aplicar la promocion a todas las facturas asociadas
    public void aplicarPromocion() {
        for (Factura factura : facturaList) {
            //Aplicar el descuento de la promocion sobre el descuento existente de la factura
            float nuevoDescuento = factura.getDescuento() + porcentajeDescuento;
            factura.setDescuento(nuevoDescuento); // Aumenta el descuento de la factura

            //Crear un nuevo ItemFactura para reflejar la promocion aplicada
            Producto productoPromocion = new Producto("Promoción aplicada", 0, descripcion);
            ItemFactura itemPromocion = new ItemFactura(1);//Cantidad 1 para el producto de promocion
            itemPromocion.agregarProducto(productoPromocion);//Agregar producto de promocion a ItemFactura

            //Agregar este ItemFactura a la factura
            factura.agregarItemFactura(itemPromocion);
        }
    }
}

