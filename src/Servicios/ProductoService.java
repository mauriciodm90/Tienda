 package Servicios;

import Entidades.Producto;
import Persistencia.ProductoDAO;
import java.util.Collection;

public class ProductoService {

    private ProductoDAO dao;

    public ProductoService() {
        this.dao = new ProductoDAO();
    }

    public void crearProducto(int codigo, String nombre, Double precio, int codigofabricante) throws Exception {

        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            if (nombre.contains("@")) {
                throw new Exception("El nombre no puede contener otros caracteres que no sean letras");
            }
            if (precio == null || precio <= 0) {
                throw new Exception("Debe indicar un precio valido");
            }
            if (codigo <= 0) {
                throw new Exception("El codigo debe ser mayor a cero");
            }
            if (buscarProductoPorCodigo(codigo) != null) {
                throw new Exception("Ya existe un producto con el codigo indicado " + codigo);
            }

            //Creamos el producto
            
            Producto producto = new Producto();
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigofabricante(codigofabricante);
            dao.guardarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarProducto(int codigo, Double nuevoprecio) throws Exception {

        try {
            //Validamos
            if (codigo <= 0) {
                throw new Exception("Debe indicar un codigo valido");
            }
            if (nuevoprecio == null || nuevoprecio <= 0) {
                throw new Exception("Debe indicar la clave nueva");
            }
            //Buscamos
            Producto auxproducto = buscarProductoPorCodigo(codigo);

            //Validamos
            if ( auxproducto.getPrecio() == nuevoprecio) {
                throw new Exception(" Precio identico al anterior");
            }
            //Modificamos
            auxproducto.setPrecio(nuevoprecio);

            dao.modificarProducto(auxproducto);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarProducto(int codigo) throws Exception {

        try {

            //Validamos 
            if (codigo <= 0) {
                throw new Exception("Debe indicar un codigo correcto");
            }
            dao.eliminarProducto(codigo);
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto buscarProductoPorCodigo(int codigo) throws Exception {

        try {

            //Validamos
            if (codigo <= 0) {
                throw new Exception("Debe indicar un codigo correcto");
            }

            Producto producto = dao.buscarProductoPorId(codigo);

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }


    public Collection<Producto> listarProducto() throws Exception {

        try {
            Collection<Producto> productos = dao.listarProducto();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProducto() throws Exception {

        try {
            //Listamos los productos
            Collection<Producto> productos = listarProducto();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    System.out.println(u);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
