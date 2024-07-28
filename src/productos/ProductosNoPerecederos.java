package productos;

public class ProductosNoPerecederos extends Productos {
    private double calorias;

    public ProductosNoPerecederos(String nombre, double precio, int cantidad, double calorias) {
        super(nombre, precio, cantidad);
        this.calorias = calorias;
    }

    public double getCalorias() {
        return calorias;
    }

    @Override
    public String toString() {
        return super.toString() +
                "calorias=" + calorias;
    }
}
