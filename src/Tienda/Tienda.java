package Tienda;

import Entidades.Fabricante;
import Entidades.Producto;
import Servicios.FabricanteService;
import Servicios.ProductoService;

public class Tienda {

    public static void main(String[] args) {
        ProductoService unproducto = new ProductoService();
        FabricanteService unfabricante = new FabricanteService();

        try {
            //Creamos  producto
            // unproducto.crearProducto(45, "Monitor", 22000.50, 1);
            // unproducto.crearProducto(26, "Notebook", 147528.00 , 2);
            unproducto.listarProducto();
            unproducto.imprimirProducto();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
        try {
            //Creamos  fabricante
            //unfabricante.crearFabricante("Hans Solutions");
            unfabricante.listarFabricante();
            unfabricante.imprimirFabricante();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }

        /*try {
            //Modificamos un producto
            unproducto.modificarProducto(45, 23000.30);
            unproducto.modificarProducto(26, 146000.00);
            unproducto.imprimirProducto();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
        
        try {
            //Modificamos un fabricante
            unfabricante.modificarFabricante("Gi and Joa and Ren and Jose");
            unfabricante.imprimirFabricante();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
        
        try {
            //Eliminamos un producto
            unproducto.eliminarProducto(45);
            unproducto.imprimirProducto();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
         try {
            //Eliminamos un fabricante
            unfabricante.eliminarFabricante("Gi and Joa and Ren and Jose");
            unfabricante.imprimirFabricante();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
        try {
            //Buscamos el Producto por el codigo
            Producto producto = unproducto.buscarProductoPorCodigo(45);
            producto.toString();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
         try {
            //Buscamos el Fabricante por el nombre
            Fabricante fabricante = unfabricante.buscarFabricantePorNombre("Gi and Joa and Ren and Jose");
            fabricante.toString();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }*/
    }
}
