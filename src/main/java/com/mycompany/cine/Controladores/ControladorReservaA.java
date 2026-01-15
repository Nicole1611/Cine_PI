package com.mycompany.cine.Controladores;

import com.mycompany.cine.Vistas.NotificadorMensajes;
import com.mycompany.cine.Vistas.VReservaAsientos;
import com.mycompany.cine.cliente.Cliente;
import com.mycompany.cine.peliculaSala.PeliculaSala;
import com.mycompany.cine.peliculaSala.PeliculaSalas;
import com.mycompany.cine.reservaAsientos.Reserva;
import com.mycompany.cine.reservaAsientos.ReservaAsientos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Queue;
import javax.swing.table.DefaultTableModel;

public class ControladorReservaA {

    private VReservaAsientos vista;
    private ReservaAsientos reservaAsientos;
    private List<Cliente> clientes;
    private PeliculaSalas funciones;
    private NotificadorMensajes notificador;

    public ControladorReservaA(VReservaAsientos vista,
                               ReservaAsientos reservaAsientos,
                               List<Cliente> clientes,
                               PeliculaSalas funciones) {
        this.vista = vista;
        this.reservaAsientos = reservaAsientos;
        this.clientes = clientes;
        this.funciones = funciones;
        this.notificador = new NotificadorMensajes();
    }

    // ---------------- AGREGAR ----------------
    public void agregarReserva() {
        try {
            int idReserva = Integer.parseInt(vista.getIdReserva());
            int idSala = Integer.parseInt(vista.getIdSala());
            int asiento = Integer.parseInt(vista.getAsiento());
            String cedula = vista.getCedula().trim();
            String pelicula = vista.getNombrePelicula().trim();

            Cliente cliente = buscarClientePorCedula(cedula);
            PeliculaSala funcion = funciones.buscar(idSala, pelicula);

            if (cliente == null || funcion == null) {
                notificador.mostrarMensaje("Cliente o función no encontrados");
                return;
            }

            int capacidad = funcion.getSala().getCapacidad();
            if (asiento < 1 || asiento > capacidad) {
                notificador.mostrarMensaje("Asiento fuera del rango de la sala");
                return;
            }

            if (reservaAsientos.estaReservado(idSala, pelicula, asiento)) {
                notificador.mostrarMensaje("El asiento ya está reservado");
                return;
            }

            Reserva r = new Reserva(cliente, funcion, idReserva, asiento, LocalDateTime.now());
            reservaAsientos.agregar(r);

            notificador.mostrarMensaje("Reserva registrada");
            vista.limpiarCampos();
            mostrarReservas();

        } catch (NumberFormatException e) {
            notificador.mostrarMensaje("Datos numéricos inválidos");
        }
    }

    // ---------------- BUSCAR (POR ID) ----------------
    public void buscarReserva() {
        try {
            int idReserva = Integer.parseInt(vista.getIdReserva());
            Reserva r = reservaAsientos.buscarPorId(idReserva);

            if (r != null) {
                vista.mostrarInfo(r.toString());
            } else {
                vista.mostrarInfo("Reserva no encontrada");
            }

        } catch (NumberFormatException e) {
            notificador.mostrarMensaje("ID de reserva inválido");
        }
    }

    // ---------------- ACTUALIZAR ----------------
    public void actualizarReserva() {
        try {
            int idReserva = Integer.parseInt(vista.getIdReserva());
            int idSala = Integer.parseInt(vista.getIdSala());
            int asiento = Integer.parseInt(vista.getAsiento());
            String cedula = vista.getCedula().trim();
            String pelicula = vista.getNombrePelicula().trim();

            Cliente cliente = buscarClientePorCedula(cedula);
            PeliculaSala funcion = funciones.buscar(idSala, pelicula);

            if (cliente == null || funcion == null) {
                notificador.mostrarMensaje("Cliente o función no encontrados");
                return;
            }

            Reserva nueva = new Reserva(cliente, funcion, idReserva, asiento, LocalDateTime.now());

            boolean ok = reservaAsientos.actualizarPorId(idReserva, nueva);

            if (ok) {
                notificador.mostrarMensaje("Reserva actualizada");
                mostrarReservas();
            } else {
                notificador.mostrarMensaje("Reserva no encontrada");
            }

        } catch (NumberFormatException e) {
            notificador.mostrarMensaje("Datos inválidos");
        }
    }

    // ---------------- ELIMINAR ----------------
    public void eliminarReserva() {
        try {
            int idReserva = Integer.parseInt(vista.getIdReserva());

            boolean eliminado = reservaAsientos.eliminarPorId(idReserva);

            if (eliminado) {
                notificador.mostrarMensaje("Reserva eliminada");
                vista.limpiarCampos();
                mostrarReservas();
            } else {
                notificador.mostrarMensaje("Reserva no encontrada");
            }

        } catch (NumberFormatException e) {
            notificador.mostrarMensaje("ID inválido");
        }
    }

    // ---------------- LISTAR ----------------
    public void mostrarReservas() {
        Queue<Reserva> lista = reservaAsientos.listar();
        StringBuilder sb = new StringBuilder();

        for (Reserva r : lista) {
            sb.append(r).append("\n----------------\n");
        }
        vista.mostrarInfo(sb.toString());
    }

    // ---------------- TABLA FUNCIONES ----------------
    public void actualizarTablaFunciones() {
        String[] columnas = {"ID Sala", "Película", "Hora"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);

        for (PeliculaSala ps : funciones.listar()) {
            model.addRow(new Object[]{
                ps.getSala().getIdSala(),
                ps.getPelicula().getNombrePelicula(),
                ps.getHora()
            });
        }
        vista.getTblFunciones().setModel(model);
    }

    // ---------------- AUXILIAR ----------------
    private Cliente buscarClientePorCedula(String cedula) {
        for (Cliente c : clientes) {
            if (c.getCedula().equals(cedula)) return c;
        }
        return null;
    }
}


