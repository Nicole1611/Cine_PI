package com.mycompany.cine.peliculaSala;

import com.mycompany.cine.pelicula.Pelicula;
import com.mycompany.cine.sala.Sala;

import java.time.LocalDateTime;

public class PeliculaSala {
    private LocalDateTime hora;
    private Sala idSala; 
    private Pelicula pelicula;

    public PeliculaSala(LocalDateTime hora, Sala idSala, Pelicula pelicula) {
        this.hora = hora;
        this.idSala = idSala;
        this.pelicula = pelicula;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public Sala getIdSala() {
        return idSala;
    }

    public void setIdSala(Sala idSala) {
        this.idSala = idSala;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}
