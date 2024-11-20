public abstract class MetodoDePago {

    private float montoPagado;
    private float cuentasPorCobrar;

    //Getters y Setters
    public float getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(float montoPagado) {
        this.montoPagado = montoPagado;
    }

    public float getCuentasPorCobrar() {
        return cuentasPorCobrar;
    }

    public void setCuentasPorCobrar(float cuentasPorCobrar) {
        this.cuentasPorCobrar = cuentasPorCobrar;
    }

    //Metodo abstracto para validar el pago
    public abstract boolean esValidoElPago();
}
