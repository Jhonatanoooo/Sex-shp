package com.taller.sexop.Controlador;

import com.taller.sexop.Entidad.Clientes;
import com.taller.sexop.Entidad.Ventas;
import com.taller.sexop.ProductService.ServiceClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ControllerClientes {
    @Autowired
    private ServiceClientes serviceClientes;
    //Historial compras
    @GetMapping("/compras/{ccCliente}")
    public List<Ventas> listaCompras(@PathVariable int ccCliente){
        return serviceClientes.listaCompras(ccCliente);
    }
    //actualizacion de datos de cliente
    @PutMapping("/actualizar/{cedula}")
    public boolean actualizarCliente(@PathVariable int cedula, @RequestBody Clientes cliente){
        return serviceClientes.actualizarCliente(
                cliente.getCcCliente(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getTelefono()
        );
    }
}
