package com.taller.sexop.ProductService;

import com.taller.sexop.Entidad.Clientes;
import com.taller.sexop.Entidad.Producto;
import com.taller.sexop.Entidad.Ventas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceAsesor {
    @Autowired
    private ServiceVentas serviceVentas;
    @Autowired
    private ServiceClientes serviceClientes;
    @Autowired
    private ServiceProducto serviceProducto;
    //regustro venta del asesor
    public UUID registrarVenta(String nombreProducto, int cantidad, float valor, int cliente){
        Ventas nuevaVenta = new Ventas (UUID.randomUUID(), nombreProducto, cantidad, valor, cliente);
        serviceVentas.agregarVenta(nuevaVenta);
        //actualizar producto en el inventario
        for(Producto producto : serviceProducto.getProductos()){
            if(producto.getNombreProducto().equals(nombreProducto)){
                int nuevaCantidad = producto.getCantidad() - cantidad;
                if(nuevaCantidad < 0){
                    throw new IllegalArgumentException("Agotado");
                }
                producto.setCantidad(nuevaCantidad);

            }
        }
        return nuevaVenta.getId();
    }
    public UUID agregarCliente(int ccCliente, String nombre, String apellido, String telefono){
        Clientes nuevoCliente = new Clientes(UUID.randomUUID(), ccCliente, nombre, apellido, telefono);
        serviceClientes.agregarCliente(nuevoCliente);
        return nuevoCliente.getIdCliente();
    }
    //inventario
    public List<Producto> listaProdustosAsesor(){
        return serviceProducto.getProductos();
    }

}
