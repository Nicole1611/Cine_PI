/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.cine.cliente;

import java.util.List;

/**
 *
 * @author User
 */
public interface IClientes {

    void crear(Cliente cliente);

    Cliente buscarPorCedula(String cedula);

    boolean actualizar(Cliente clienteActualizado);

    boolean eliminar(String cedula);

    List<Cliente> listar();
}

