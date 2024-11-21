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

        // Crear Producto
        Producto producto1 = new Producto("Ceviche de pescado", 9.99f, "Ceviche de pescado Peruano");
        Producto producto2 = new Producto("Jarra de limonada", 5.99f, "Jarra de limonada helada");
        Producto producto3 = new Producto("Pescado frito", 7.50f, "Corvina frita");

        //Crear items del pedido
        ItemPedido itemPedido = new ItemPedido(23.48f, "Orden de comida");

        //Agregar productos al ItemPedido
        itemPedido.agregarProducto(producto1);
        itemPedido.agregarProducto(producto2);
        itemPedido.agregarProducto(producto3);

        //Crear items de factura
        ItemFactura item1 = new ItemFactura(2, producto1);
        ItemFactura item2 = new ItemFactura(3, producto2);
        ItemFactura item3 = new ItemFactura(2, producto3);

        //Asociar items a los productos
        producto1.agregarItemFactura(item1);
        producto2.agregarItemFactura(item2);
        producto3.agregarItemFactura(item3);

        //Mostrar detalle del pedido
        cliente.mostrarInformacion();
        pedido.mostrarDetalle();
        itemPedido.mostrarProductos();
        //Mostrar items asociados a cada producto
        producto1.mostrarItemsFactura();
        producto2.mostrarItemsFactura();
        producto3.mostrarItemsFactura();

        //Crear fecha
        Date fechaFactura = new Date();  // Fecha actual

        //Crear una factura y pasar el cliente, descuento, extras y fecha
        Factura factura = new Factura(101, cliente, 10, 50, fechaFactura); // Descuento del 10%, extras $50

        //Agregar items a la factura
        factura.agregarItemFactura(item1);
        factura.agregarItemFactura(item2);
        factura.agregarItemFactura(item3);

        //Crear promocion
        Promocion promocionDescuentoCumpleaños = new Promocion("cumpleaños", 10); // Promoción del 10%

        //Asociar facturas a la promocion
        promocionDescuentoCumpleaños.agregarFactura(factura);

        //Aplicar promocion
        promocionDescuentoCumpleaños.aplicarPromocion();

        //Imprimir factura
        System.out.println(factura.imprimirFactura());

        //Crear metodos de pago
        PagoEfectivo efectivo = new PagoEfectivo(150, 101.596f); // Cambio = 50
        // Asociar métodos de pago a la factura
        factura.agregarMetodoDePago(efectivo);

        //Mostrar detalles de los metodos de pago
        factura.mostrarMetodosDePago();

        //Enviar factura por correo
        factura.enviarFacturaAlCorreo();

        //Crear Historial
        HistorialFactura historial = new HistorialFactura();

        //Agregar facturas al historial
        historial.agregarFactura(factura);

        //Mostrar el historial completo
        historial.mostrarHistorial();

        //Consultar por rango de montos
        historial.consultarPorMonto(100, 300);
    }
}

