import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistorialFactura {

    private List<Factura> facturaList; //Relacion de agregacion con Factura

    //Constructor
    public HistorialFactura() {
        this.facturaList = new ArrayList<>();
    }

    //Metodos para gestionar las facturas
    public void agregarFactura(Factura factura) {
        facturaList.add(factura);
        System.out.println("Factura #" + factura.getNumero() + " agregada al historial.");
    }

    public void consultarFacturasPorFecha(Date fecha) {
        System.out.println("Consultando facturas por fecha: " + fecha);
        for (Factura factura : facturaList) {

        }
    }

    public void consultarPorCliente(String clienteNombre) {
        System.out.println("Consultando facturas por cliente: " + clienteNombre);
        for (Factura factura : facturaList) {
        }
    }

    public void consultarPorMonto(float montoMinimo, float montoMaximo) {
        System.out.println("Consultando facturas con montos entre " + montoMinimo + " y " + montoMaximo);
        for (Factura factura : facturaList) {
            if (factura.calcularMontoTotal() >= montoMinimo && factura.calcularMontoTotal() <= montoMaximo) {
                System.out.println(factura.imprimirFactura());
            }
        }
    }

    //Metodo adicional para mostrar todas las facturas
    public void mostrarHistorial() {
        System.out.println("Historial de facturas:");
        for (Factura factura : facturaList) {
            System.out.println(factura.imprimirFactura());
        }
    }
}
