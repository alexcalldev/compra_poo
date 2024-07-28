package productos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductosPerecederos extends Productos {
    private Date fechaVencimiento;

    public ProductosPerecederos(String nombre, double precio, int cantidad, String fechaVencimiento) {
        super(nombre, precio, cantidad);
        SimpleDateFormat sd = new SimpleDateFormat("dd, MM 'del' yyyy");
        try {
            this.fechaVencimiento = sd.parse(fechaVencimiento);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }


    @Override
    public String toString() {
        SimpleDateFormat sd = new SimpleDateFormat("dd MM 'del' yyyy");
        return super.toString() +
                " , fechaVencimiento= " + sd.format(fechaVencimiento);
    }
}
