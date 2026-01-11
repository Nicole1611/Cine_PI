package com.mycompany.cine.peliculaSala;

import java.time.LocalDateTime;
import java.util.List;

public interface IPeliculaSalas {

    boolean crear(int idSala, String nombrePelicula, LocalDateTime hora);

    PeliculaSala buscar(int idSala, String nombrePelicula);

    boolean actualizar(int idSala, String nombrePelicula, LocalDateTime nuevaHora);

    boolean eliminar(int idSala, String nombrePelicula);

    List<PeliculaSala> listar();
}

