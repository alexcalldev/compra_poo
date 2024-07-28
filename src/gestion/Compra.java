package gestion;
import productos.*;

public class Compra {
    private Productos producto;
    private int cantidad;
    private Vendedor vendedor;

    public Compra(Productos producto, int cantidad, Vendedor vendedor) {
        if(cantidad > producto.getCantidad()){
            throw new RuntimeException("Cantidad superar el stock");
        }
        this.producto = producto;
        this.cantidad = cantidad;
        this.vendedor = vendedor;
    }

    public Productos getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    @Override
    public String toString() {
        return  "Producto: " + producto.getNombre() +
                ", Tipo: " + getTipoProducto() +
                ", Cantidad: " + cantidad +
                ", Precio: " + producto.getPrecio() +
                ", Vendedor: " + vendedor.getNombre() + " " + vendedor.getApellido();
    }

    private String getTipoProducto() {
        if (producto instanceof ProductosPerecederos) {
            return "Perecedero";
        } else if (producto instanceof  ProductosNoPerecederos) {
            return "No perecedero";
        } else if (producto instanceof  ProductoLimpieza) {
            return "Limpieza";
        }
        return "Desconocido";
    }
}
