package Entidades;

public class Fabricante {

    private String nombrefabricante;
    private int codigo;

    public Fabricante() {
    }

    public Fabricante(String nombrefabricante, int codigo) {
        this.nombrefabricante = nombrefabricante;
        this.codigo = codigo;
    }

    public String getNombrefabricante() {
        return nombrefabricante;
    }

    public void setNombrefabricante(String nombrefabricante) {
        this.nombrefabricante = nombrefabricante;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Fabricante{" + "nombrefabricante=" + nombrefabricante + ", codigo=" + codigo + '}';
    }

    public String getnombrefabricante() {
        return null;

    }

    public void setnombrefabricante(String nombrefabricante) {

    }

}
