
package Entidades;


public class Producto {
    private int codigo;
    private String nombre;
    private Double precio;
    private int codigofabricante;

    public Producto() {
    }

    public Producto(int codigo, String nombre, Double precio, int codigofabricante) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.codigofabricante = codigofabricante;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCodigofabricante() {
        return codigofabricante;
    }

    public void setCodigofabricante(int codigofabricante) {
        this.codigofabricante = codigofabricante;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", codigofabricante=" + codigofabricante + '}';
    }  
    
}
