package com.mycompany.cine.cliente;

public class Cliente {
    private String cedula;
    private String nombre;
    private int edad;

    public Cliente(String cedula, String nombre, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
