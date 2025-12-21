package com.mycompany.cine.sala;

public class Sala {
    private int idSala;
    private int capacidad;

    public Sala(int capacidad, int idSala) {
        this.capacidad = capacidad;
        this.idSala = idSala;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "capacidad=" + capacidad +
                ", idSala=" + idSala +
                '}';
    }
}
