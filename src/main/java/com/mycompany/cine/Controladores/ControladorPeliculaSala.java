
package com.mycompany.cine.Controladores;

import com.mycompany.cine.Vistas.NotificadorMensajes;
import com.mycompany.cine.Vistas.VPeliculaSala;
import com.mycompany.cine.peliculaSala.PeliculaSala;
import com.mycompany.cine.peliculaSala.PeliculaSalas;
import com.mycompany.cine.sala.Salas;
import com.mycompany.cine.pelicula.Peliculas;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class ControladorPeliculaSala {

    private VPeliculaSala vista;
    private PeliculaSalas peliculaSalas;
    private NotificadorMensajes notificador;

    // ---------------- CONSTRUCTOR ----------------
    public ControladorPeliculaSala(VPeliculaSala vista,
                                   Salas salas,
                                   Peliculas peliculas) {

        this.vista = vista;
        this.notificador = new NotificadorMensajes();
        this.peliculaSalas = new PeliculaSalas(salas, peliculas);
    }

    // ---------------- CREAR PROYECCIÓN ----------------
    public void crearPeliculaSala() {
        try {
            String idTexto = vista.getIdSala().trim();
            String nombre = vista.getNombrePelicula().trim();
            String horaTexto = vista.getHora().trim();

            if (idTexto.isEmpty() || nombre.isEmpty() || horaTexto.isEmpty()) {
                notificador.mostrarMensaje("Todos los campos son obligatorios");
                return;
            }

            int idSala;
            try {
                idSala = Integer.parseInt(idTexto);
            } catch (NumberFormatException e) {
                notificador.mostrarMensaje("El ID de la sala debe ser numérico");
                return;
            }

            LocalDateTime hora;
            try {
                hora = LocalDateTime.parse(horaTexto);
            } catch (DateTimeParseException e) {
                notificador.mostrarMensaje(
                    "Formato de hora inválido (yyyy-MM-ddTHH:mm)"
                );
                return;
            }

            boolean creado = peliculaSalas.crear(idSala, nombre, hora);

            if (creado) {
                notificador.mostrarMensaje("Proyección creada correctamente");
                vista.limpiarCampos();
                mostrarProyecciones();
            } else {
                notificador.mostrarMensaje(
                    "Error: la sala o la película no existen"
                );
            }

        } catch (Exception e) {
            notificador.mostrarMensaje("Error al crear la proyección");
        }
    }

    // ---------------- BUSCAR PROYECCIÓN ----------------
    public void buscarPeliculaSala() {
        try {
            int idSala = Integer.parseInt(vista.getIdSala());
            String nombre = vista.getNombrePelicula();

            PeliculaSala ps = peliculaSalas.buscar(idSala, nombre);

            if (ps != null) {
                vista.mostrarResultado(ps.toString());
            } else {
                notificador.mostrarMensaje("Proyección no encontrada");
            }

        } catch (NumberFormatException e) {
            notificador.mostrarMensaje("El ID de la sala debe ser numérico");
        } catch (Exception e) {
            notificador.mostrarMensaje("Error al buscar la proyección");
        }
    }

    // ---------------- ACTUALIZAR PROYECCIÓN ----------------
    public void actualizarPeliculaSala() {
        try {
            int idSala = Integer.parseInt(vista.getIdSala());
            String nombre = vista.getNombrePelicula();
            LocalDateTime nuevaHora = LocalDateTime.parse(vista.getHora());

            boolean actualizado = peliculaSalas.actualizar(
                idSala, nombre, nuevaHora
            );

            if (actualizado) {
                notificador.mostrarMensaje("Proyección actualizada correctamente");
                vista.limpiarCampos();
                mostrarProyecciones();
            } else {
                notificador.mostrarMensaje("No se encontró la proyección");
            }

        } catch (NumberFormatException e) {
            notificador.mostrarMensaje("ID inválido");
        } catch (DateTimeParseException e) {
            notificador.mostrarMensaje("Formato de hora inválido");
        } catch (Exception e) {
            notificador.mostrarMensaje("Error al actualizar la proyección");
        }
    }

    // ---------------- ELIMINAR PROYECCIÓN ----------------
    public void eliminarPeliculaSala() {
        try {
            int idSala = Integer.parseInt(vista.getIdSala());
            String nombre = vista.getNombrePelicula();

            boolean eliminado = peliculaSalas.eliminar(idSala, nombre);

            if (eliminado) {
                notificador.mostrarMensaje("Proyección eliminada correctamente");
                vista.limpiarCampos();
                mostrarProyecciones();
            } else {
                notificador.mostrarMensaje("Proyección no encontrada");
            }

        } catch (NumberFormatException e) {
            notificador.mostrarMensaje("El ID de la sala debe ser numérico");
        } catch (Exception e) {
            notificador.mostrarMensaje("Error al eliminar la proyección");
        }
    }

    // ---------------- LISTAR PROYECCIONES ----------------
    public void mostrarProyecciones() {
        StringBuilder sb = new StringBuilder();

        for (PeliculaSala ps : peliculaSalas.listar()) {
            sb.append(ps.toString());
            sb.append("---------------------------------\n");
        }

        vista.mostrarResultado(sb.toString());
    }
}

