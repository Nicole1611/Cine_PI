package com.mycompany.cine.Controladores;

import com.mycompany.cine.cliente.Cliente;
import com.mycompany.cine.cliente.Clientes;
import com.mycompany.cine.Vistas.NotificadorMensajes;
import com.mycompany.cine.Vistas.VCliente;

public class ControladorClientes {

    private VCliente vistaCliente;
    private Clientes iClientes;
    private NotificadorMensajes notificadorMensajes;

    // ---------------- CONSTRUCTOR ----------------
    public ControladorClientes(VCliente vistaCliente) {
        this.vistaCliente = vistaCliente;
        this.notificadorMensajes = new NotificadorMensajes();
        this.iClientes = new Clientes();
    }

    // ---------------- CREAR CLIENTE ----------------
    public void procesoControladorClientes() {
    try {
        String cedula = vistaCliente.getCedula().trim();
        String nombre = vistaCliente.getNombre().trim();
        String edadTexto = vistaCliente.getEdad().trim();

        if (cedula.isEmpty() || nombre.isEmpty() || edadTexto.isEmpty()) {
            notificadorMensajes.mostrarMensaje("Todos los campos son obligatorios");
            return;
        }

        int edad;
        try {
            edad = Integer.parseInt(edadTexto);
        } catch (NumberFormatException e) {
            notificadorMensajes.mostrarMensaje("La edad debe ser un número");
            return;
        }

        if (iClientes.buscarPorCedula(cedula) != null) {
            notificadorMensajes.mostrarMensaje("La cédula ya está registrada");
            return;
        }

        Cliente cliente = new Cliente(cedula, nombre, edad);
        iClientes.crear(cliente);

        notificadorMensajes.mostrarMensaje("Cliente agregado correctamente");
        vistaCliente.limpiarCampos();
        mostrarClientes();

    } catch (Exception e) {
        notificadorMensajes.mostrarMensaje("Error al registrar cliente");
    }
}


    // ---------------- BUSCAR CLIENTE ----------------
    public void buscarCliente() {
        try {
            String cedula = vistaCliente.getCedula();
            Cliente c = iClientes.buscarPorCedula(cedula);

            if (c != null) {
                vistaCliente.setNombre(c.getNombre());
                vistaCliente.setEdad(String.valueOf(c.getEdad()));

                vistaCliente.mostrarClientes(
                    "CLIENTE ENCONTRADO\n" +
                    "Cédula: " + c.getCedula() + "\n" +
                    "Nombre: " + c.getNombre() + "\n" +
                    "Edad: " + c.getEdad()
                );
            } else {
                notificadorMensajes.mostrarMensaje("Cliente no encontrado");
            }

        } catch (Exception e) {
            notificadorMensajes.mostrarMensaje("Error al buscar cliente");
        }
    }

    // ---------------- ACTUALIZAR CLIENTE ----------------
    public void actualizarCliente() {
        try {
            String cedula = vistaCliente.getCedula();
            String nombre = vistaCliente.getNombre();
            int edad = Integer.parseInt(vistaCliente.getEdad());

            Cliente cliente = new Cliente(cedula, nombre, edad);

            boolean actualizado = iClientes.actualizar(cliente);

            if (actualizado) {
                notificadorMensajes.mostrarMensaje("Cliente actualizado correctamente");
                vistaCliente.limpiarCampos();
                mostrarClientes();
            } else {
                notificadorMensajes.mostrarMensaje("No existe cliente con esa cédula");
            }

        } catch (NumberFormatException e) {
            notificadorMensajes.mostrarMensaje("Edad inválida");
        } catch (Exception e) {
            notificadorMensajes.mostrarMensaje("Error al actualizar cliente");
        }
    }

    // ---------------- ELIMINAR CLIENTE ----------------
    public void eliminarCliente() {
        try {
            String cedula = vistaCliente.getCedula();

            boolean eliminado = iClientes.eliminar(cedula);

            if (eliminado) {
                notificadorMensajes.mostrarMensaje("Cliente eliminado correctamente");
                vistaCliente.limpiarCampos();
                mostrarClientes();
            } else {
                notificadorMensajes.mostrarMensaje("Cliente no encontrado");
            }

        } catch (Exception e) {
            notificadorMensajes.mostrarMensaje("Error al eliminar cliente");
        }
    }

    // ---------------- LISTAR CLIENTES EN TEXTAREA ----------------
    public void mostrarClientes() {
        StringBuilder sb = new StringBuilder();

        for (Cliente c : iClientes.listar()) {
            sb.append("Cédula: ").append(c.getCedula()).append("\n");
            sb.append("Nombre: ").append(c.getNombre()).append("\n");
            sb.append("Edad: ").append(c.getEdad()).append("\n");
            sb.append("---------------------------------\n");
        }

        vistaCliente.mostrarClientes(sb.toString());
    }
}
