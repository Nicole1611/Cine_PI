/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cine.reservaAsientos;

import com.mycompany.cine.cliente.Cliente;
import com.mycompany.cine.peliculaSala.PeliculaSala;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reserva {
    private int idReserva;
    private Cliente cliente;
    private PeliculaSala proyeccion;   // FUNCIÓN
    private int numeroAsientos;
    private LocalDateTime fechaReserva;

    public Reserva(Cliente cliente, PeliculaSala proyeccion, int idReserva,
                   int numeroAsientos, LocalDateTime fechaReserva) {
        this.cliente = cliente;
        this.proyeccion = proyeccion;
        this.numeroAsientos = numeroAsientos;
        this.fechaReserva = fechaReserva;
        this.idReserva = idReserva;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public PeliculaSala getProyeccion() {
        return proyeccion;
    }

    public void setProyeccion(PeliculaSala proyeccion) {
        this.proyeccion = proyeccion;
    }

    public int getNumeroAsientos() {
        return numeroAsientos;
    }

    public void setNumeroAsientos(int numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    
    
    
    @Override
    public String toString() {
        return "RESERVA\n" +
                "ID de la Reserva:"+idReserva + "\n"+
               "Cliente: " + cliente.getCedula() + "\n" +
               "Película: " + proyeccion.getPelicula().getNombrePelicula() + "\n" +
               "Sala: " + proyeccion.getSala().getIdSala() + "\n" +
               "Función: " + proyeccion.getHora() + "\n" +
               "Asientos: " + numeroAsientos + "\n" +
               "Fecha reserva: " + fechaReserva + "\n";
    }
}
