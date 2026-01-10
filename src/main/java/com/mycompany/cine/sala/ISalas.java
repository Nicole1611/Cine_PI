package com.mycompany.cine.sala;


import java.util.ArrayList;
import java.util.List;

public interface ISalas {
    
    void crear(Sala sala);

    Sala buscarPorId(int IdSala);

    boolean actualizar(Sala salaActualizado);

    boolean eliminar(int IdSala);

    List<Sala> listar();
    
}
