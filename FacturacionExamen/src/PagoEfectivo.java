public class PagoEfectivo extends MetodoDePago {

    private float cambio;

    //Constructor
    public PagoEfectivo(float montoPagado, float cuentasPorCobrar) {
        setMontoPagado(montoPagado);
        setCuentasPorCobrar(cuentasPorCobrar);
        this.cambio = calcularCambio();
    }

    public float getCambio() {
        return cambio;
    }

    private void setCambio(float cambio) {
        this.cambio = cambio;
    }

    public float calcularCambio() {
        return getMontoPagado() - getCuentasPorCobrar();
    }

    @Override
    public boolean esValidoElPago() {
        return getMontoPagado() >= getCuentasPorCobrar();
    }

    @Override
    public String toString() {
        return "PagoEfectivo{" +
                "montoPagado=" + getMontoPagado() +
                ", cuentasPorCobrar=" + getCuentasPorCobrar() +
                ", cambio=" + calcularCambio() +
                '}';
    }
}
