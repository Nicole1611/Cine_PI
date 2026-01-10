package com.mycompany.cine.pelicula;

import java.util.ArrayList;
import java.util.List;

public class Peliculas implements IPeliculas {

    private List<Pelicula> peliculas;

    public Peliculas() {
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void crear(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    public Pelicula buscarPorNombre(String nombrePelicula) {
        for (Pelicula p : peliculas) {
            if (p.getNombrePelicula().equalsIgnoreCase(nombrePelicula)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean actualizar(Pelicula peliculaActualizada) {
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getNombrePelicula().equalsIgnoreCase(peliculaActualizada.getNombrePelicula())) {
                peliculas.set(i, peliculaActualizada);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(String nombrePelicula) {
        return peliculas.removeIf(p -> p.getNombrePelicula().equalsIgnoreCase(nombrePelicula));
    }

    @Override
    public List<Pelicula> listar() {
        return new ArrayList<>(peliculas);
    }
}
