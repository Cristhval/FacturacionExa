import java.util.Date;

public class PagoTarjeta extends MetodoDePago {

    private int numeroTarjeta;
    private String titular;
    private Date vencimiento;

    // Constructor
    public PagoTarjeta(float montoPagado, float cuentasPorCobrar, int numeroTarjeta, String titular, Date vencimiento) {
        setMontoPagado(montoPagado);
        setCuentasPorCobrar(cuentasPorCobrar);
        this.numeroTarjeta = numeroTarjeta;
        this.titular = titular;
        this.vencimiento = vencimiento;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    @Override
    public boolean esValidoElPago() {
        // Supongamos que un pago con tarjeta es válido si la tarjeta no ha vencido.
        return new Date().before(vencimiento);
    }
}
