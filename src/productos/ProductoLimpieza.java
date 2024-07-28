package productos;

public class ProductoLimpieza extends Productos {
    private String tipoLimpieza;
    private int litros;

    public ProductoLimpieza(String nombre, int precio, int cantidad, String tipoLimpieza, int litros) {
        super(nombre, precio, cantidad);
        this.tipoLimpieza = tipoLimpieza;
        this.litros = litros;
    }

    public String getTipoLimpieza() {
        return tipoLimpieza;
    }

    public int getLitros() {
        return litros;
    }

    @Override
    public String toString() {
        return super.toString() +
                "tipo de Limpieza = " + tipoLimpieza +
                ", litros= " + litros ;
    }
}
