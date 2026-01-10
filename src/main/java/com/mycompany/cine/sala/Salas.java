package com.mycompany.cine.sala;

import java.util.ArrayList;
import java.util.List;

public class Salas implements ISalas {

    private ArrayList<Sala> salas;

    public Salas() {
        this.salas = new ArrayList<>();
    }

    @Override
    public void crear(Sala sala) {
        salas.add(sala);
    }

    @Override
    public Sala buscarPorId(int idSala) {
        for (Sala s : salas) {
            if (s.getIdSala() == idSala) {
                return s;
            }
        }
        return null; // si no se encuentra
    }

    @Override
    public boolean actualizar(Sala salaActualizada) {
        for (int i = 0; i < salas.size(); i++) {
            if (salas.get(i).getIdSala() == salaActualizada.getIdSala()) {
                salas.set(i, salaActualizada);
                return true; // actualización exitosa
            }
        }
        return false; // no se encontró la sala
    }

    @Override
    public boolean eliminar(int idSala) {
        return salas.removeIf(s -> s.getIdSala() == idSala);
    }

    @Override
    public List<Sala> listar() {
        return salas; // devuelve copia de la lista
    }
}

