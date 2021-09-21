package Servicios;

import Entidades.Fabricante;
import Persistencia.FabricanteDAO;
import java.util.Collection;

public class FabricanteService {

    private FabricanteDAO dao;

    public FabricanteService() {
        this.dao = new FabricanteDAO();
    }

    public void crearFabricante(String nombrefabricante) throws Exception {

        try {
            //Validamos
            if (nombrefabricante == null || nombrefabricante.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            if (nombrefabricante.contains("@")) {
                throw new Exception("El nombre no puede contener otros caracteres que no sean letras");
            }

            //Creamos el producto
            Fabricante fabricante = new Fabricante();
            fabricante.setnombrefabricante(nombrefabricante);
            dao.guardarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarFabricante(String newnombrefabricante) throws Exception {

        try {
            //Validamos
            if (newnombrefabricante == null || newnombrefabricante.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            if (newnombrefabricante.contains("@")) {
                throw new Exception("El nombre no puede contener otros caracteres que no sean letras");
            }
            //Buscamos
            Fabricante auxfabricante = buscarFabricantePorNombre(newnombrefabricante);

            //Validamos
            if (auxfabricante.getnombrefabricante().equalsIgnoreCase(newnombrefabricante)) {
                throw new Exception(" Nombre identico al anterior");
            }
            //Modificamos
            auxfabricante.setnombrefabricante(newnombrefabricante);

            dao.modificarFabricante(auxfabricante);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarFabricante(String nombrefabricante) throws Exception {

        try {

            //Validamos 
            if (nombrefabricante == null || nombrefabricante.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            if (nombrefabricante.contains("@")) {
                throw new Exception("El nombre no puede contener otros caracteres que no sean letras");
            }
            dao.eliminarFabricante(nombrefabricante);
        } catch (Exception e) {
            throw e;
        }
    }

    public Fabricante buscarFabricantePorNombre(String nombrefabricante) throws Exception {

        try {

            //Validamos
            if (nombrefabricante == null || nombrefabricante.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            if (nombrefabricante.contains("@")) {
                throw new Exception("El nombre no puede contener otros caracteres que no sean letras");
            }

            Fabricante fabricante = dao.buscarFabricantePorNombre(nombrefabricante);

            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Fabricante> listarFabricante() throws Exception {

        try {
            Collection<Fabricante> fabricante = dao.listarFabricante();
            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirFabricante() throws Exception {

        try {
            //Listamos los productos
            Collection<Fabricante> fabricantes = listarFabricante();

            //Imprimimos los productos
            if (fabricantes.isEmpty()) {
                throw new Exception("No existen fabricantes para imprimir");
            } else {
                for (Fabricante u : fabricantes) {
                    System.out.println(u);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
