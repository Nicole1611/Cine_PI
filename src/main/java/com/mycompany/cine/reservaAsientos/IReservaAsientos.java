/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cine.reservaAsientos;

import java.util.Queue;

public interface IReservaAsientos {

    void agregar(Reserva r);

    // Buscar una reserva por su ID único
    Reserva buscarPorId(int idReserva);

    // Actualizar una reserva identificada por ID
    boolean actualizarPorId(int idReserva, Reserva nueva);

    // Eliminar una reserva por ID
    boolean eliminarPorId(int idReserva);

    // Listar todas las reservas
    Queue<Reserva> listar();
}


