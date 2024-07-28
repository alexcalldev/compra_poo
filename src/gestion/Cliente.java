package gestion;

public class Cliente extends Vendedor{
    private int clienteId;

    public Cliente(String nombre, String apellido, int clienteId) {
        super(nombre, apellido);
        this.clienteId = clienteId;
    }

    public int getClienteId() {
        return clienteId;
    }

    @Override
    public String toString() {
        return super.toString() +
                "clienteId: " + clienteId;
    }
}
