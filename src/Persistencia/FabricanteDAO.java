
package Persistencia;

import Entidades.Fabricante;
import java.util.ArrayList;
import java.util.Collection;


public final class FabricanteDAO extends DAO {
    
    public void guardarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el Fabricante");
            }
            String sql = "INSERT INTO Fabricante (nombrefabricante) "
                    + "VALUES ( '" + fabricante.getnombrefabricante();

            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el fabricante que desea modificar");
            }
            String sql = "UPDATE Fabricante SET "
                    + " nombre = '" + fabricante.getnombrefabricante()
                    + " WHERE nombre = '" + fabricante.getnombrefabricante()+ "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarFabricante(String nombrefabricante) throws Exception {
        try {
            String sql = "DELETE FROM Fabricante WHERE nombrefabricante = " + nombrefabricante + "";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Fabricante buscarFabricantePorNombre(String nombrefabricante) throws Exception {
        try {
            String sql = "SELECT * FROM Fabricante WHERE nombrefabricante = " + nombrefabricante + "";
            consultarBase(sql);
            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setnombrefabricante(resultado.getString(1));
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Fabricante> listarFabricante() throws Exception {
        try {
            String sql = "SELECT * FROM Fabricante ";
            consultarBase(sql);
            Fabricante fabricante = null;
            Collection<Fabricante> fabricantes = new ArrayList();
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setnombrefabricante(resultado.getString(2));
                fabricantes.add(fabricante);
            }
            desconectarBase();
            return fabricantes;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
}
