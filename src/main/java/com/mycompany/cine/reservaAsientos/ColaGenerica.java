/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cine.reservaAsientos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Predicate;

public class ColaGenerica<T> {

    private Queue<T> cola;

    public ColaGenerica() {
        this.cola = new LinkedList<>();
    }

    // Agregar elemento
    public void encolar(T elemento) {
        cola.offer(elemento);
    }

    // Buscar elemento según condición
    public T buscar(Predicate<T> condicion) {
        for (T e : cola) {
            if (condicion.test(e)) {
                return e;
            }
        }
        return null;
    }

    // Eliminar elemento(s) según condición
    public boolean eliminar(Predicate<T> condicion) {
        boolean eliminado = false;
        Queue<T> aux = new LinkedList<>();

        while (!cola.isEmpty()) {
            T e = cola.poll();
            if (condicion.test(e)) {
                eliminado = true;
            } else {
                aux.offer(e);
            }
        }
        cola = aux;
        return eliminado;
    }

    // Listar todos los elementos
    public Queue<T> listar() {
        return new LinkedList<>(cola);
    }
}
