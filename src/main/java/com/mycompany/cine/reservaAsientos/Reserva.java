/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cine.reservaAsientos;

import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class Reserva {
    private LocalDate fecha; 
    private int numeroAsientos; 
    private String cedula; 
    private int salaID; 
    
    public Reserva(LocalDate fecha, int numeroAsientos, String cedula, int salaID) {
        this.fecha = fecha;
        this.numeroAsientos = numeroAsientos;
        this.cedula = cedula;
        this.salaID = salaID;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getNumeroAsientos() {
        return numeroAsientos;
    }

    public void setNumeroAsientos(int numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getSalaID() {
        return salaID;
    }

    public void setSalaID(int salaID) {
        this.salaID = salaID;
    }

    @Override
    public String toString() {
        return "Reserva{" + "fecha=" + fecha + ", numeroAsientos=" + numeroAsientos + ", cedula=" + cedula + ", salaID=" + salaID + '}';
    }
    
    
    
    
}
