package com.mycompany.cine.Controladores;

import com.mycompany.cine.Vistas.NotificadorMensajes;
import com.mycompany.cine.Vistas.VCliente;
import com.mycompany.cine.cliente.Cliente;

import java.util.List;

public class ControladorClientes {

    private VCliente vistaCliente;
    private List<Cliente> clientes; // lista compartida con ControladorReservaA
    private NotificadorMensajes notificador;

    // ---------------- CONSTRUCTOR ----------------
    public ControladorClientes(VCliente vistaCliente, List<Cliente> clientes) {
        this.vistaCliente = vistaCliente;
        this.clientes = clientes; // lista compartida
        this.notificador = new NotificadorMensajes();
    }

    // ---------------- CREAR CLIENTE ----------------
    public void agregarCliente() {
        try {
            String cedula = vistaCliente.getCedula().trim();
            String nombre = vistaCliente.getNombre().trim();
            String edadTexto = vistaCliente.getEdad().trim();

            if (cedula.isEmpty() || nombre.isEmpty() || edadTexto.isEmpty()) {
                notificador.mostrarMensaje("Todos los campos son obligatorios");
                return;
            }

            int edad;
            try {
                edad = Integer.parseInt(edadTexto);
            } catch (NumberFormatException e) {
                notificador.mostrarMensaje("La edad debe ser un número");
                return;
            }

            // Verificar que no exista cliente con esa cédula
            for (Cliente c : clientes) {
                if (c.getCedula().equals(cedula)) {
                    notificador.mostrarMensaje("La cédula ya está registrada");
                    return;
                }
            }

            Cliente cliente = new Cliente(cedula, nombre, edad);
            clientes.add(cliente);

            notificador.mostrarMensaje("Cliente agregado correctamente");
            vistaCliente.limpiarCampos();
            mostrarClientes();

        } catch (Exception e) {
            notificador.mostrarMensaje("Error al registrar cliente");
        }
    }

    // ---------------- BUSCAR CLIENTE ----------------
    public void buscarCliente() {
        try {
            String cedula = vistaCliente.getCedula().trim();
            Cliente encontrado = null;

            for (Cliente c : clientes) {
                if (c.getCedula().equals(cedula)) {
                    encontrado = c;
                    break;
                }
            }

            if (encontrado != null) {
                vistaCliente.setNombre(encontrado.getNombre());
                vistaCliente.setEdad(String.valueOf(encontrado.getEdad()));

                vistaCliente.mostrarClientes(
                    "CLIENTE ENCONTRADO\n" +
                    "Cédula: " + encontrado.getCedula() + "\n" +
                    "Nombre: " + encontrado.getNombre() + "\n" +
                    "Edad: " + encontrado.getEdad()
                );
            } else {
                notificador.mostrarMensaje("Cliente no encontrado");
            }

        } catch (Exception e) {
            notificador.mostrarMensaje("Error al buscar cliente");
        }
    }

    // ---------------- ACTUALIZAR CLIENTE ----------------
    public void actualizarCliente() {
        try {
            String cedula = vistaCliente.getCedula().trim();
            String nombre = vistaCliente.getNombre().trim();
            int edad = Integer.parseInt(vistaCliente.getEdad().trim());

            Cliente cliente = null;
            for (Cliente c : clientes) {
                if (c.getCedula().equals(cedula)) {
                    cliente = c;
                    break;
                }
            }

            if (cliente != null) {
                cliente.setNombre(nombre);
                cliente.setEdad(edad);
                notificador.mostrarMensaje("Cliente actualizado correctamente");
                vistaCliente.limpiarCampos();
                mostrarClientes();
            } else {
                notificador.mostrarMensaje("No existe cliente con esa cédula");
            }

        } catch (NumberFormatException e) {
            notificador.mostrarMensaje("Edad inválida");
        } catch (Exception e) {
            notificador.mostrarMensaje("Error al actualizar cliente");
        }
    }

    // ---------------- ELIMINAR CLIENTE ----------------
    public void eliminarCliente() {
        try {
            String cedula = vistaCliente.getCedula().trim();
            Cliente aEliminar = null;

            for (Cliente c : clientes) {
                if (c.getCedula().equals(cedula)) {
                    aEliminar = c;
                    break;
                }
            }

            if (aEliminar != null) {
                clientes.remove(aEliminar);
                notificador.mostrarMensaje("Cliente eliminado correctamente");
                vistaCliente.limpiarCampos();
                mostrarClientes();
            } else {
                notificador.mostrarMensaje("Cliente no encontrado");
            }

        } catch (Exception e) {
            notificador.mostrarMensaje("Error al eliminar cliente");
        }
    }

    // ---------------- LISTAR CLIENTES ----------------
    public void mostrarClientes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Clientes:\n------------------------\n");
        for (Cliente c : clientes) {
            sb.append("Cédula: ").append(c.getCedula()).append("\n");
            sb.append("Nombre: ").append(c.getNombre()).append("\n");
            sb.append("Edad: ").append(c.getEdad()).append("\n");
            sb.append("---------------------------------\n");
        }

        vistaCliente.mostrarClientes(sb.toString());
    }

    // ---------------- OBTENER CLIENTE POR CÉDULA ----------------
    public Cliente obtenerClientePorCedula(String cedula) {
        for (Cliente c : clientes) {
            if (c.getCedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }
}
