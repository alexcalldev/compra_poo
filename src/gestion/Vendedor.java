package gestion;

public class Vendedor {
    private int id;
    private String nombre;
    private String apellido;

    public Vendedor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "nombre = " + nombre +
                " , apellido = " + apellido +
                " , vendedorId = " + id;
    }
}
