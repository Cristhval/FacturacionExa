import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

    private EstadoPedido estadoPedido;
    private int numero;
    private Date fecha;
    private List<ItemPedido> itemPedidoList;

    //Constructor
    public Pedido(EstadoPedido estadoPedido, int numero, Date fecha) {
        this.estadoPedido = estadoPedido;
        this.numero = numero;
        this.fecha = fecha;
        this.itemPedidoList = new ArrayList<>();
    }

    //Getters y Setters
    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

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

    public List<ItemPedido> getItemPedidoList() {
        return itemPedidoList;
    }

    //Metodos para manejar la lista de ItemPedido
    public void agregarItemPedido(ItemPedido itemPedido) {
        itemPedidoList.add(itemPedido);
    }

    public void eliminarItemPedido(ItemPedido itemPedido) {
        itemPedidoList.remove(itemPedido);
    }

    public void mostrarDetalle() {
        System.out.println("Detalle del pedido #" + numero + " - Estado: " + estadoPedido);
        System.out.println("Items:");
        for (ItemPedido item : itemPedidoList) {
            System.out.println("  - " + item.obtenerDescripcion() + " - Precio Unitario: " + item.getPrecioUnitario());
        }
    }
}
