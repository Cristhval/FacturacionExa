import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Factura implements DescuentoAplicable {

    private int numero;
    private Date fecha;//Fecha de emision de la factura
    private Cliente cliente;//Cliente asociado a la factura
    private float total;
    private float impuestoTotal;
    private float descuento;
    private float extras;
    private List<ItemFactura> itemFacturaList; //Relacion de composicion con ItemFactura
    private List<MetodoDePago> metodoDePagoList; //Relacion de asociacion con MetodoDePago


    //Constructor
    public Factura(int numero, Cliente cliente, float descuento, float extras, Date fecha) {
        this.numero = numero;
        this.cliente = cliente;
        this.descuento = descuento;
        this.extras = extras;
        this.fecha = fecha;  //Asignar la fecha de la factura
        this.itemFacturaList = new ArrayList<>();
        this.metodoDePagoList = new ArrayList<>();
        this.total = 0; //Inicializamos el total
        this.impuestoTotal = 0;
    }

    //Getters y setters para la fecha
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getTotal() {
        return total;
    }

    public float getImpuestoTotal() {
        return impuestoTotal;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getExtras() {
        return extras;
    }

    public void setExtras(float extras) {
        this.extras = extras;
    }

    public List<ItemFactura> getItemFacturaList() {
        return itemFacturaList;
    }

    public List<MetodoDePago> getMetodoDePagoList() {
        return metodoDePagoList;
    }

    //Metodos para gestionar los ItemFactura
    public void agregarItemFactura(ItemFactura itemFactura) {
        itemFacturaList.add(itemFactura);
        recalcularTotal();
    }

    public void eliminarItemFactura(ItemFactura itemFactura) {
        itemFacturaList.remove(itemFactura);
        recalcularTotal();
    }

    //Recalcular el total
    private void recalcularTotal() {
        total = 0;
        for (ItemFactura item : itemFacturaList) {
            total += item.getSubtotal();
        }
        total = aplicarDescuento() + extras; // Aplica descuento y agrega extras
        impuestoTotal = total * 0.10f; // Impuesto del 10%
    }

    //Implementacion del metodo de la interfaz
    @Override
    public float aplicarDescuento() {
        return total * (1 - descuento / 100); // Descuento como porcentaje
    }

    //Metodos para gestionar metodos de Pago
    public void agregarMetodoDePago(MetodoDePago metodoDePago) {
        metodoDePagoList.add(metodoDePago);
    }

    public void eliminarMetodoDePago(MetodoDePago metodoDePago) {
        metodoDePagoList.remove(metodoDePago);
    }

    public void mostrarMetodosDePago() {
        System.out.println("Métodos de pago asociados a la factura #" + numero + ":");
        for (MetodoDePago metodo : metodoDePagoList) {
            System.out.println("  - " + metodo.toString());
        }
    }

    //Metodos adicionales
    public float calcularMontoTotal() {
        return total + impuestoTotal;
    }

    public String imprimirFactura() {
        StringBuilder factura = new StringBuilder();
        factura.append("Factura #").append(numero).append("\n");
        factura.append("Fecha: ").append(fecha).append("\n");
        factura.append("Cliente: ").append(cliente.getNombre()).append(" ").append(cliente.getApellido()).append("\n");
        factura.append("Dirección: ").append(cliente.getDireccion()).append("\n");
        factura.append("Correo Electrónico: ").append(cliente.getCorreoElectronico()).append("\n");
        factura.append("Items:\n");

        for (ItemFactura item : itemFacturaList) {
            for (Producto producto : item.getProductos()) {
                factura.append("  - Producto: ").append(producto.getNombre())
                        .append(", Cantidad: ").append(item.getCantidad())
                        .append(", Subtotal: $").append(item.getSubtotal()).append("\n");
            }
        }

        factura.append("Total: $").append(total).append("\n");
        factura.append("Descuento aplicado: ").append(descuento).append("%\n");
        factura.append("Extras: $").append(extras).append("\n");
        factura.append("Impuesto Total: $").append(impuestoTotal).append("\n");
        factura.append("Monto Total: $").append(calcularMontoTotal()).append("\n");
        return factura.toString();
    }

    public void enviarFacturaAlCorreo() {
        System.out.println("Enviando factura #" + numero + " al correo del cliente " + cliente.getCorreoElectronico() + ".");
    }
}
