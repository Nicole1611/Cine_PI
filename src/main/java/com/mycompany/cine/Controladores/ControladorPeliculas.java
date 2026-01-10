/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cine.Controladores;

import com.mycompany.cine.Vistas.NotificadorMensajes;
import com.mycompany.cine.Vistas.VPelicula;
import com.mycompany.cine.pelicula.Genero;
import com.mycompany.cine.pelicula.Pelicula;
import com.mycompany.cine.pelicula.Peliculas;
import java.util.List;

public class ControladorPeliculas {

    private VPelicula vistaPelicula;
    private Peliculas iPeliculas;
    private NotificadorMensajes notificadorMensajes;

    public ControladorPeliculas(VPelicula vistaPelicula) {
        this.vistaPelicula = vistaPelicula;
        this.notificadorMensajes = new NotificadorMensajes();
        this.iPeliculas = new Peliculas();
    }

    public void crearPelicula() {
        try {
            String nombre = vistaPelicula.getNombrePelicula().trim();
            String prioridad = vistaPelicula.getPrioridad().trim();
            Genero genero = Genero.valueOf(vistaPelicula.getGeneroTexto());
            if (nombre.isEmpty() || prioridad.isEmpty() || genero == null) {
                notificadorMensajes.mostrarMensaje("Todos los campos son obligatorios");
                return;
            }
            if (iPeliculas.buscarPorNombre(nombre) != null) {
                notificadorMensajes.mostrarMensaje("La película ya está registrada");
                return;
            }
            Pelicula nueva = new Pelicula(genero, nombre, prioridad);
            iPeliculas.crear(nueva);
            notificadorMensajes.mostrarMensaje("Película agregada correctamente");
            vistaPelicula.limpiarCampos();
            mostrarPeliculas();
        } catch (Exception e) {
            e.printStackTrace();
            notificadorMensajes.mostrarMensaje("Error al crear película");
        }
    }

    public void buscarPelicula() {
        try {
            String nombre = vistaPelicula.getNombrePelicula();
            Pelicula p = iPeliculas.buscarPorNombre(nombre);
            if (p != null) {
                vistaPelicula.setPrioridad(p.getPrioridad());
                vistaPelicula.setGenero(p.getGenero());
                vistaPelicula.mostrarPeliculas(p.toString());
            } else {
                notificadorMensajes.mostrarMensaje("Película no encontrada");
            }
        } catch (Exception e) {
            notificadorMensajes.mostrarMensaje("Error al buscar película");
        }
    }

    public void actualizarPelicula() {
        try {
            String nombre = vistaPelicula.getNombrePelicula();
            String prioridad = vistaPelicula.getPrioridad();
            Genero genero = Genero.valueOf(vistaPelicula.getGeneroTexto());
            Pelicula actualizada = new Pelicula(genero, nombre, prioridad);
            boolean ok = iPeliculas.actualizar(actualizada);
            if (ok) {
                notificadorMensajes.mostrarMensaje("Película actualizada correctamente");
                vistaPelicula.limpiarCampos();
                mostrarPeliculas();
            } else {
                notificadorMensajes.mostrarMensaje("No se encontró la película");
            }
        } catch (Exception e) {
            notificadorMensajes.mostrarMensaje("Error al actualizar película");
        }
    }

    public void eliminarPelicula() {
        try {
            String nombre = vistaPelicula.getNombrePelicula();
            boolean ok = iPeliculas.eliminar(nombre);
            if (ok) {
                notificadorMensajes.mostrarMensaje("Película eliminada correctamente");
                vistaPelicula.limpiarCampos();
                mostrarPeliculas();
            } else {
                notificadorMensajes.mostrarMensaje("Película no encontrada");
            }
        } catch (Exception e) {
            notificadorMensajes.mostrarMensaje("Error al eliminar película");
        }
    }

    public void mostrarPeliculas() {
        List<Pelicula> lista = iPeliculas.listar(); // Ordenar por nombre de película
        lista.sort((p1, p2) -> p1.getNombrePelicula().compareToIgnoreCase(p2.getNombrePelicula()));
        StringBuilder sb = new StringBuilder();
        sb.append("=== LISTA DE PELÍCULAS ===\n");
        for (Pelicula p : lista) {
            sb.append("Nombre: ").append(p.getNombrePelicula()).append("\n")
              .append("Género: ").append(p.getGenero()).append("\n")
              .append("Prioridad: ").append(p.getPrioridad()).append("\n")
              .append("-------------------------\n");
        }
        vistaPelicula.mostrarPeliculas(sb.toString());
    }
}
