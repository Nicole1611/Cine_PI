package com.mycompany.cine.reservaAsientos;

import java.util.Queue;

public class ReservaAsientos implements IReservaAsientos {

    private ColaGenerica<Reserva> colaReservas;
    private int contadorId = 1; // genera IDs únicos

    public ReservaAsientos() {
        this.colaReservas = new ColaGenerica<>();
    }

    // ---------------- AGREGAR ----------------
    @Override
    public void agregar(Reserva r) {
        r.setIdReserva(contadorId++);
        colaReservas.encolar(r);
    }

    // ---------------- BUSCAR POR ID ----------------
    public Reserva buscarPorId(int idReserva) {
        return colaReservas.buscar(r -> r.getIdReserva() == idReserva);
    }

    // ---------------- ACTUALIZAR POR ID ----------------
    public boolean actualizarPorId(int idReserva, Reserva nueva) {
        boolean eliminado = colaReservas.eliminar(r -> r.getIdReserva() == idReserva);
        if (eliminado) {
            colaReservas.encolar(nueva);
        }
        return eliminado;
    }

    // ---------------- ELIMINAR POR ID ----------------
    public boolean eliminarPorId(int idReserva) {
        return colaReservas.eliminar(r -> r.getIdReserva() == idReserva);
    }

    // ---------------- LISTAR ----------------
    @Override
    public Queue<Reserva> listar() {
        return colaReservas.listar();
    }

    // ---------------- VALIDAR ASIENTO ----------------
    public boolean estaReservado(int idSala, String nombrePelicula, int numeroAsiento) {
        for (Reserva r : colaReservas.listar()) {
            if (r.getProyeccion().getSala().getIdSala() == idSala &&
                r.getProyeccion().getPelicula().getNombrePelicula().equalsIgnoreCase(nombrePelicula) &&
                r.getNumeroAsientos() == numeroAsiento) {
                return true;
            }
        }
        return false;
    }
}

