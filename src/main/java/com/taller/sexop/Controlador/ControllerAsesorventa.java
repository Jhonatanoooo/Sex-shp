package com.taller.sexop.Controlador;

import com.taller.sexop.Entidad.Clientes;
import com.taller.sexop.Entidad.Producto;
import com.taller.sexop.Entidad.Ventas;
import com.taller.sexop.ProductService.ServiceAsesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/asesores")
public class ControllerAsesorventa {
    @Autowired
    private ServiceAsesor serviceAsesor;
    //resgistro de venta del asesor
    @PostMapping("/RegistrarVenta")
    public ResponseEntity<?> registroVentaAsesor(@RequestBody Ventas venta) {
        try {
            UUID ventaId = serviceAsesor.registrarVenta(
                    venta.getNombreProducto(),venta.getCantidad(),venta.getValor(),venta.getCcCliente()
            );
            return ResponseEntity.ok(ventaId);
        }
        catch (IllegalArgumentException e){
            //validacion
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    //registro de cliente
    @PostMapping("/RegistrarVenta/cliente")
    public UUID registroCliente(@RequestBody Clientes cliente) {
        return serviceAsesor.agregarCliente(cliente.getCcCliente(),cliente.getNombre(),cliente.getApellido(),cliente.getTelefono());
    }
    //Producto visto
    @GetMapping("/productos")
    public List<Producto> listarProductos() {
        return serviceAsesor.listaProdustosAsesor();
    }



}
