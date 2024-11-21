public class PagoTransferencia extends MetodoDePago {

    private int numeroTransferencia;
    private String bancoOrigen;

    //Constructor
    public PagoTransferencia(float montoPagado, float cuentasPorCobrar, int numeroTransferencia, String bancoOrigen) {
        setMontoPagado(montoPagado);
        setCuentasPorCobrar(cuentasPorCobrar);
        this.numeroTransferencia = numeroTransferencia;
        this.bancoOrigen = bancoOrigen;
    }

    public int getNumeroTransferencia() {
        return numeroTransferencia;
    }

    public void setNumeroTransferencia(int numeroTransferencia) {
        this.numeroTransferencia = numeroTransferencia;
    }

    public String getBancoOrigen() {
        return bancoOrigen;
    }

    public void setBancoOrigen(String bancoOrigen) {
        this.bancoOrigen = bancoOrigen;
    }

    @Override
    public boolean esValidoElPago() {
        //Validamos la transferencia si hay un numero de transferencia y un banco de origen.
        return numeroTransferencia > 0 && bancoOrigen != null && !bancoOrigen.isEmpty();
    }
}
