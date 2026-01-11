package com.mycompany.cine.pelicula;

public class Pelicula {
    private String nombrePelicula;
    private Genero genero;
    private String prioridad; //Adultos-Jovenes-General

    public Pelicula(Genero genero, String nombrePelicula, String prioridad) {
        this.genero = genero;
        this.nombrePelicula = nombrePelicula;
        this.prioridad = prioridad;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    @Override
public String toString() {
    return "PELÍCULA ENCONTRADA\n" +
           "-------------------\n" +
           "Nombre: " + nombrePelicula + "\n" +
           "Género: " + genero + "\n" +
           "Prioridad: " + prioridad + "\n";
}

}
