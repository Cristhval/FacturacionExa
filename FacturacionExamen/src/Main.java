import java.util.Date;

public class Main {
    public static void main(String[] args) {

        //Crear Cliente
        Cliente cliente = new Cliente(
                "Juan",
                "Fernandez",
                "Calle Quito",
                "juanFe777@gmai.com",
                "12345678",
                "098895746");

        //Crear Pedido
        Pedido pedido = new Pedido(EstadoPedido.PENDIENTE, 1, new Date());

        //Crear items del pedido
        ItemPedido item1 = new ItemPedido(9.99f, "Ceviche de Pescado");
        ItemPedido item2 = new ItemPedido(5.99f, "Jarra de limonada");

        //Agregar items al pedido
        pedido.agregarItemPedido(item1);
        pedido.agregarItemPedido(item2);

        //Mostrar detalle del pedido
        pedido.mostrarDetalle();
        cliente.mostrarInformacion();


    }
}