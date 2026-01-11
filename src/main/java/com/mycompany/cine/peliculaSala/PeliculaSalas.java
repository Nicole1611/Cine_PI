package com.mycompany.cine.peliculaSala;

import com.mycompany.cine.sala.Sala;
import com.mycompany.cine.sala.Salas;
import com.mycompany.cine.pelicula.Pelicula;
import com.mycompany.cine.pelicula.Peliculas;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeliculaSalas implements IPeliculaSalas {

    private List<PeliculaSala> lista;
    private Salas salasDAO;
    private Peliculas peliculasDAO;

    // 👉 Recibe los DAO existentes (NO los crea)
    public PeliculaSalas(Salas salasDAO, Peliculas peliculasDAO) {
        this.lista = new ArrayList<>();
        this.salasDAO = salasDAO;
        this.peliculasDAO = peliculasDAO;
    }

    // ---------------- CREAR ----------------
    @Override
    public boolean crear(int idSala, String nombrePelicula, LocalDateTime hora) {

        Sala sala = salasDAO.buscarPorId(idSala);
        Pelicula pelicula = peliculasDAO.buscarPorNombre(nombrePelicula);

        if (sala == null || pelicula == null) {
            return false;
        }

        PeliculaSala ps = new PeliculaSala(hora, sala, pelicula);
        lista.add(ps);
        return true;
    }

    // ---------------- BUSCAR ----------------
    @Override
    public PeliculaSala buscar(int idSala, String nombrePelicula) {
        for (PeliculaSala ps : lista) {
            if (ps.getSala().getIdSala() == idSala &&
                ps.getPelicula().getNombrePelicula().equalsIgnoreCase(nombrePelicula)) {
                return ps;
            }
        }
        return null;
    }

    // ---------------- ACTUALIZAR ----------------
    @Override
    public boolean actualizar(int idSala, String nombrePelicula, LocalDateTime nuevaHora) {
        PeliculaSala ps = buscar(idSala, nombrePelicula);
        if (ps != null) {
            ps.setHora(nuevaHora);
            return true;
        }
        return false;
    }

    // ---------------- ELIMINAR ----------------
    @Override
    public boolean eliminar(int idSala, String nombrePelicula) {
        Iterator<PeliculaSala> it = lista.iterator();
        while (it.hasNext()) {
            PeliculaSala ps = it.next();
            if (ps.getSala().getIdSala() == idSala &&
                ps.getPelicula().getNombrePelicula().equalsIgnoreCase(nombrePelicula)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    // ---------------- LISTAR ----------------
    @Override
    public List<PeliculaSala> listar() {
        return new ArrayList<>(lista);
    }
}


