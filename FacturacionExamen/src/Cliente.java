import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {

    private List<Pedido> pedidoList;

    //Constructor
    public Cliente(String nombre, String apellido, String direccion, String correoElectronico,
                   String numeroCedula, String numeroTelefono) {
        super(nombre, apellido, direccion, correoElectronico, numeroCedula, numeroTelefono);
        this.pedidoList = new ArrayList<>();
    }

    //Metodos para gestionar los pedidos
    public void agregarPedido(Pedido pedido) {
        pedidoList.add(pedido);
    }

    public void eliminarPedido(Pedido pedido) {
        pedidoList.remove(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidoList;
    }

    //Metodo abstracto implementado
    @Override
    public void mostrarInformacion() {
        System.out.println("Cliente:");
        System.out.println("Nombre: " + getNombre() + " " + getApellido());
        System.out.println("Direccion: " + getDireccion());
        System.out.println("Correo Electronico: " + getCorreoElectronico());
        System.out.println("Numero de Cedula: " + getNumeroCedula());
        System.out.println("Numero de Telefono: " + getNumeroTelefono());
        System.out.println("Pedidos:");
        for (Pedido pedido : pedidoList) {
            System.out.println("  Pedido #" + pedido.getNumero() +
                    " - Fecha: " + pedido.getFecha() +
                    " - Estado: " + pedido.getEstadoPedido());
        }
    }
}
