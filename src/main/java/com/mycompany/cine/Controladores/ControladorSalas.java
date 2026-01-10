
package com.mycompany.cine.Controladores;

import com.mycompany.cine.Vistas.NotificadorMensajes;
import com.mycompany.cine.Vistas.VSalas;
import com.mycompany.cine.sala.Sala;
import com.mycompany.cine.sala.Salas;


public class ControladorSalas {

    private VSalas vistaSala;              // tu vista Swing para salas
    private Salas iSalas;                 // gestor de salas
    private NotificadorMensajes notificadorMensajes;

    // ---------------- CONSTRUCTOR ----------------
    public ControladorSalas(VSalas vistaSala) {
        this.vistaSala = vistaSala;
        this.notificadorMensajes = new NotificadorMensajes();
        this.iSalas = new Salas();
    }

    // ---------------- CREAR SALA ----------------
    public void procesoControladorSalas() {
        try {
            String idTexto = vistaSala.getIdSala().trim();
            String capacidadTexto = vistaSala.getCapacidad().trim();

            if (idTexto.isEmpty() || capacidadTexto.isEmpty()) {
                notificadorMensajes.mostrarMensaje("Todos los campos son obligatorios");
                return;
            }

            int idSala;
            int capacidad;
            try {
                idSala = Integer.parseInt(idTexto);
                capacidad = Integer.parseInt(capacidadTexto);
            } catch (NumberFormatException e) {
                notificadorMensajes.mostrarMensaje("ID y capacidad deben ser números");
                return;
            }

            if (iSalas.buscarPorId(idSala) != null) {
                notificadorMensajes.mostrarMensaje("El ID ya está registrado");
                return;
            }

            Sala sala = new Sala(capacidad, idSala);
            iSalas.crear(sala);

            notificadorMensajes.mostrarMensaje("Sala agregada correctamente");
            vistaSala.limpiarCampos();
            mostrarSalas();

        } catch (Exception e) {
            notificadorMensajes.mostrarMensaje("Error al registrar sala");
        }
    }

    // ---------------- BUSCAR SALA ----------------
    public void buscarSala() {
        try {
            int idSala = Integer.parseInt(vistaSala.getIdSala());
            Sala s = iSalas.buscarPorId(idSala);

            if (s != null) {
                vistaSala.setCapacidad(String.valueOf(s.getCapacidad()));

                vistaSala.mostrarSalas(
                    "SALA ENCONTRADA\n" +
                    "ID: " + s.getIdSala() + "\n" +
                    "Capacidad: " + s.getCapacidad()
                );
            } else {
                notificadorMensajes.mostrarMensaje("Sala no encontrada");
            }

        } catch (NumberFormatException e) {
            notificadorMensajes.mostrarMensaje("El ID debe ser un número");
        } catch (Exception e) {
            notificadorMensajes.mostrarMensaje("Error al buscar sala");
        }
    }

    // ---------------- ACTUALIZAR SALA ----------------
    public void actualizarSala() {
        try {
            int idSala = Integer.parseInt(vistaSala.getIdSala());
            int capacidad = Integer.parseInt(vistaSala.getCapacidad());

            Sala sala = new Sala(capacidad, idSala);

            boolean actualizado = iSalas.actualizar(sala);

            if (actualizado) {
                notificadorMensajes.mostrarMensaje("Sala actualizada correctamente");
                vistaSala.limpiarCampos();
                mostrarSalas();
            } else {
                notificadorMensajes.mostrarMensaje("No existe sala con ese ID");
            }

        } catch (NumberFormatException e) {
            notificadorMensajes.mostrarMensaje("ID y capacidad inválidos");
        } catch (Exception e) {
            notificadorMensajes.mostrarMensaje("Error al actualizar sala");
        }
    }

    // ---------------- ELIMINAR SALA ----------------
    public void eliminarSala() {
        try {
            int idSala = Integer.parseInt(vistaSala.getIdSala());

            boolean eliminado = iSalas.eliminar(idSala);

            if (eliminado) {
                notificadorMensajes.mostrarMensaje("Sala eliminada correctamente");
                vistaSala.limpiarCampos();
                mostrarSalas();
            } else {
                notificadorMensajes.mostrarMensaje("Sala no encontrada");
            }

        } catch (NumberFormatException e) {
            notificadorMensajes.mostrarMensaje("El ID debe ser un número");
        } catch (Exception e) {
            notificadorMensajes.mostrarMensaje("Error al eliminar sala");
        }
    }

    // ---------------- LISTAR SALAS EN TEXTAREA ----------------
    public void mostrarSalas() {
        StringBuilder sb = new StringBuilder();

        for (Sala s : iSalas.listar()) {
            sb.append("ID: ").append(s.getIdSala()).append("\n");
            sb.append("Capacidad: ").append(s.getCapacidad()).append("\n");
            sb.append("---------------------------------\n");
        }

        vistaSala.mostrarSalas(sb.toString());
    }
}

