package Persistencia;

import Entidades.Producto;
import java.util.ArrayList;
import java.util.Collection;

public final class ProductoDAO extends DAO {

    public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el Producto");
            }
            String sql = "INSERT INTO Producto (codigo, nombre, precio, codigofabricante) "
                    + "VALUES ( '" + producto.getCodigo() + "' , '" + producto.getNombre() + "' ," + producto.getPrecio() + "' ," + producto.getCodigofabricante() + " );";

            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto que desea modificar");
            }
            String sql = "UPDATE Producto SET "
                    + " codigo = '" + producto.getCodigo() + "' , nombre = '" + producto.getNombre() + "' , precio = " + producto.getPrecio() + "' , codigofabricante = " + producto.getCodigofabricante()
                    + " WHERE codigo = '" + producto.getCodigo() + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarProducto(int codigo) throws Exception {
        try {
            String sql = "DELETE FROM Producto WHERE codigo = " + codigo + "";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Producto buscarProductoPorId(int codigo) throws Exception {
        try {
            String sql = "SELECT * FROM Producto WHERE codigo = " + codigo + "";
            consultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigofabricante(resultado.getInt(4));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Producto> listarProducto() throws Exception {
        try {
            String sql = "SELECT * FROM producto ";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigofabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
}
