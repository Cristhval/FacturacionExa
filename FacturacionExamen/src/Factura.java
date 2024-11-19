public class Factura implements DescuentoAplicable{

    private int numero;
    private float total;
    private float impuestoTotal;
    private float descuento;
    private float extras;

    public float calcularMontoTotal(){

        return 0;
    }
    public String imprimirFactura(){

        return "";
    }

    public void enviarFacturaAlCorreo(){

    }

    public String registrarMetodoDePago(){

        return "";
    }

    @Override
    public float aplicarDescuento() {
        return 0;
    }
}
