package productos;

public class Productos {
    private String nombre;
    private double precio;
    private int cantidad;

    public Productos(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void reducirCantidad(int cantidad) {
        if (cantidad <= this.cantidad) {
            this.cantidad -= cantidad;
        } else {
            throw new RuntimeException("Cantidad solicitada supera el stock disponible.");
        }
    }

    @Override
    public String toString() {
        return  "nombre= " + nombre +
                ", precio= " + precio +
                ", cantidad= " + cantidad;
    }
}
