package gestion;

import productos.ProductoLimpieza;
import productos.Productos;
import productos.ProductosNoPerecederos;
import productos.ProductosPerecederos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EjemploAlmacen {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese el nombre del cliente: ");
        String nombreCliente = entrada.nextLine();

        ProductosPerecederos[] productosPerecederos = {
                new ProductosPerecederos("Atun", 3.5, 10, "14, 05 del 2025"),
                new ProductosPerecederos("Galleta", 2.7, 10, "17, 07 del 2024"),
                new ProductosPerecederos("Mermelada", 5.7, 10, "12, 08 del 2024")
        };
        ProductoLimpieza[] productosLimpieza = {
                new ProductoLimpieza("Poet", 3, 10, "Para Piso", 3),
                new ProductoLimpieza("Windows", 8, 10, "Limpia Vidrio", 1),
                new ProductoLimpieza("Baygon", 11, 10, "Mata todo", 1)
        };
        ProductosNoPerecederos[] productosNoPerecederos = {
                new ProductosNoPerecederos("Almendra", 12, 10, 0.5),
                new ProductosNoPerecederos("Mani", 7, 10, 0.8)
        };
        Vendedor[] vendedores = {
                new Vendedor("Alexander", "Calle"),
                new Vendedor("Manuel", "Sanchez")
        };
        vendedores[0].setId(1);
        vendedores[1].setId(2);

        System.out.println("El stock de nuestros productos es: ");
        mostrarStock(productosPerecederos, productosNoPerecederos, productosLimpieza);

        System.out.println("Los vendedores de turno son: ");
        mostrarVendedores(vendedores);

        List<Compra> compras = new ArrayList<>();
        while (true) {
            System.out.println("Ingrese el nombre del producto a comprar o 'finalizar' para cerrar tu OC");
            String nombreProducto = entrada.nextLine();
            if (nombreProducto.equalsIgnoreCase("finalizar")) {
                break;
            }

            System.out.println("Ingrese la cantidad a comprar");
            int cantidad = entrada.nextInt();
            entrada.nextLine();

            System.out.println("Ingrese el ID de vendedor");
            int idVendedor = entrada.nextInt();
            entrada.nextLine();

            Productos producto = buscarProducto(nombreProducto, productosPerecederos, productosNoPerecederos, productosLimpieza);
            Vendedor vendedor = buscarVendedorPorId(idVendedor, vendedores);

            if (producto != null && vendedor != null) {
                try {
                    compras.add(new Compra(producto, cantidad, vendedor));
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("No se encontro el producto o el vendedor. Intente de nuevo");
            }
        }
        System.out.println("\nDetalle de la compra");
        double total = 0;
        for (Compra compra : compras) {
            double subTotal = compra.getProducto().getPrecio() * compra.getCantidad();
            total += subTotal;
            System.out.println(compra + " Subtotal: " + subTotal);
        }
        System.out.println("Total a pagar " + total);
    }

    private static void mostrarStock(ProductosPerecederos[] productosPerecederos, ProductosNoPerecederos[] productosNoPerecederos, ProductoLimpieza[] productosLimpieza) {
        System.out.println("Productos perecederos");
        for (ProductosPerecederos producto : productosPerecederos) {
            System.out.println(producto);
        }
        System.out.println("\nProductos no perecederos");
        for (ProductosNoPerecederos producto : productosNoPerecederos) {
            System.out.println(producto);
        }
        System.out.println("\nProductos de limpieza");
        for (ProductoLimpieza producto : productosLimpieza) {
            System.out.println(producto);
        }
    }

    private static void mostrarVendedores(Vendedor[] vendedores) {
        for (Vendedor vendedor : vendedores) {
            System.out.println("ID: " + vendedor.getId() + ", Nombre: " +
                    vendedor.getNombre() + " " + vendedor.getApellido());
        }
    }

    private static Productos buscarProducto(String nombre, ProductosPerecederos[] productosPerecederos,
                                            ProductosNoPerecederos[] productosNoPerecederos,
                                            ProductoLimpieza[] productosLimpieza) {
        for (ProductosPerecederos producto : productosPerecederos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        for (ProductosNoPerecederos producto : productosNoPerecederos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        for (ProductoLimpieza producto : productosLimpieza) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    private static Vendedor buscarVendedorPorId(int id, Vendedor[] vendedores) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getId() == id) {
                return vendedor;
            }
        }
        return null;
    }
}
