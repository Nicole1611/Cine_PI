package com.mycompany.cine.peliculaSala;

import com.mycompany.cine.pelicula.Pelicula;
import com.mycompany.cine.sala.Sala;

import java.time.LocalDateTime;

public class PeliculaSala {
    private LocalDateTime hora;
    private Sala sala; 
    private Pelicula pelicula;

    public PeliculaSala(LocalDateTime hora, Sala sala, Pelicula pelicula) {
        this.hora = hora;
        this.sala = sala;
        this.pelicula = pelicula;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
    
    @Override
    public String toString() {
    return "PROYECCIÓN\n" +
           "-------------------\n" +
           "Película: " + pelicula.getNombrePelicula() + "\n" +
           "Género: " + pelicula.getGenero() + "\n" +
           "Sala: " + sala.getIdSala() + "\n" +
           "Capacidad: " + sala.getCapacidad() + "\n" +
           "Hora: " + hora + "\n";
}

}
