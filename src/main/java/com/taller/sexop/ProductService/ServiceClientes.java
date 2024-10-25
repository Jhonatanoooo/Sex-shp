package com.taller.sexop.ProductService;

import com.taller.sexop.Entidad.Clientes;
import com.taller.sexop.Entidad.Ventas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceClientes {
    @Autowired
    private ServiceVentas servicesVentas;
    private List<Clientes> listaClientes = new ArrayList<>();

    //Historial de clientes para admin
    public List<Clientes> getListaClientes() {
        try {

        }
        catch (Exception e) {

        }
        return listaClientes;
    }
    // clientes
    public void agregarCliente(Clientes cliente) {
        //agregar cliente a la lista
        listaClientes.add(cliente);
    }

    //actualizar cliente
    public boolean actualizarCliente(int Clientes, String nombre, String apellido, String telefono) {
        for (Clientes cliente : listaClientes) {
            if (cliente.getCcCliente() == Clientes) {
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setTelefono(telefono);
                return true;
            }
        }
        return false;
    }
    //borrar datos
    public boolean eliminarCliente(int Clientes) {
        for (Clientes cliente : listaClientes) {
            if (cliente.getCcCliente() == Clientes) {
                listaClientes.remove(cliente);
                return true;
            }
        }
        return false;
    }
    //el cliente puede ver su compra
    public List<Ventas> listaCompras(int Clientes) {
        List<Ventas> comprasCliente = new ArrayList<>();
        for (Ventas compra : servicesVentas.getVentas()) {
            if (compra.getCcCliente() == Clientes) {
                comprasCliente.add(compra);
            }
        }
        return comprasCliente;
    }
}
