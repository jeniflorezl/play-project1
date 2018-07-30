package models;

import vo.Tipo;

public class Producto {
    private Integer id;
    private String nombre;
    private Tipo tipo;
    private Double costo;

    public Producto(){

    }

    public Producto(Integer id, String nombre, Tipo tipo, Double costo){
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.costo = costo;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Double getCosto() {
        return costo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
}
