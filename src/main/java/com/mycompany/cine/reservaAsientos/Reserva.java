/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cine.reservaAsientos;

import com.mycompany.cine.cliente.Cliente;
import com.mycompany.cine.sala.Sala;

import java.time.LocalDate;


public class Reserva {
    private LocalDate fecha; 
    private int numeroAsientos; 
    private Cliente cedula;
    private Sala idSala;

    public Reserva(Cliente cedula, int numeroAsientos, Sala idSala, LocalDate fecha) {
        this.cedula = cedula;
        this.numeroAsientos = numeroAsientos;
        this.idSala = idSala;
        this.fecha = fecha;
    }

    public Cliente getCedula() {
        return cedula;
    }

    public void setCedula(Cliente cedula) {
        this.cedula = cedula;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Sala getIdSala() {
        return idSala;
    }

    public void setIdSala(Sala idSala) {
        this.idSala = idSala;
    }

    public int getNumeroAsientos() {
        return numeroAsientos;
    }

    public void setNumeroAsientos(int numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "cedula=" + cedula +
                ", fecha=" + fecha +
                ", numeroAsientos=" + numeroAsientos +
                ", idSala=" + idSala +
                '}';
    }
}
