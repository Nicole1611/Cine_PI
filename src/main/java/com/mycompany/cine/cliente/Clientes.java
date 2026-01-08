
package com.mycompany.cine.cliente;

import java.util.ArrayList;
import java.util.List;

public class Clientes implements IClientes {

    private ArrayList<Cliente> clientes = new ArrayList<>();

    @Override
    public void crear(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente buscarPorCedula(String cedula) {
        for (Cliente c : clientes) {
            if (c.getCedula().equalsIgnoreCase(cedula)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public boolean actualizar(Cliente clienteActualizado) {
        for (Cliente c : clientes) {
            if (c.getCedula().equalsIgnoreCase(clienteActualizado.getCedula())) {
                c.setNombre(clienteActualizado.getNombre());
                c.setEdad(clienteActualizado.getEdad());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(String cedula) {
        for (Cliente c : clientes) {
            if (c.getCedula().equalsIgnoreCase(cedula)) {
                clientes.remove(c);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Cliente> listar() {
        return clientes;
    }
}
