
package com.mycompany.ejemploexamenp2.app;

import com.mycompany.ejemploexamenp2.modelo.Producto;
import com.mycompany.ejemploexamenp2.servicio.Inventario;

public class Main {
    public static void main(String[] args) {

        Inventario inventario = new Inventario();

        // Agregar productos válidos
        inventario.agregarProducto(new Producto("Laptop", 1200.0, 5));
        inventario.agregarProducto(new Producto("Mouse", 20.0, 0));
        inventario.agregarProducto(new Producto("Teclado", 45.0, 10));

        // Producto inválido
        try {
            Producto invalido = new Producto("", -10, -1);
            inventario.agregarProducto(invalido);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear producto: " + e.getMessage());
        }

        // Mostrar productos
        for (Producto p : inventario.obtenerProductos()) {
            System.out.println(
                "Producto: " + p.getNombre() +
                " - Precio: " + p.getPrecio() +
                " - Stock: " + p.getStock()
            );
        }

        // Buscar producto existente
        Producto encontrado = inventario.buscarPorNombre("Laptop");
        if (encontrado != null) {
            System.out.println("Producto encontrado: " + encontrado.getNombre());
        } else {
            System.out.println("Producto no encontrado");
        }

        // Buscar producto inexistente
        Producto noEncontrado = inventario.buscarPorNombre("Monitor");
        if (noEncontrado != null) {
            System.out.println("Producto encontrado: " + noEncontrado.getNombre());
        } else {
            System.out.println("Producto no encontrado");
        }
    }
}
