package com.mycompany.cine.pelicula;

import java.util.List;

public interface IPeliculas {

    void crear(Pelicula pelicula);

    Pelicula buscarPorNombre(String nombrePelicula);

    boolean actualizar(Pelicula peliculaActualizada);

    boolean eliminar(String nombrePelicula);

    List<Pelicula> listar();
}
