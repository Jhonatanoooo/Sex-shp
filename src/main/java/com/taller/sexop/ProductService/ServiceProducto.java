package com.taller.sexop.ProductService;

import com.taller.sexop.Entidad.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceProducto {
    //declarar lista
    private List<Producto> productos;

    //agregar contenido a la lista
    public ServiceProducto() {
        productos = new ArrayList<>();
        productos.add(new Producto(UUID.randomUUID(), "Vibrador", "Juguetes Eróticos", 35.00, 4));
        productos.add(new Producto(UUID.randomUUID(), "Lubricante", "Accesorios", 12.50, 5));
        productos.add(new Producto(UUID.randomUUID(), "Bolas Chinas", "Juguetes Eróticos", 25.00, 3));
        productos.add(new Producto(UUID.randomUUID(), "Preservativos", "Accesorios", 10.00, 10));
        productos.add(new Producto(UUID.randomUUID(), "Aceite de Masaje", "Cuidado Personal", 15.00, 2));
        productos.add(new Producto(UUID.randomUUID(), "Esposas", "Juguetes Eróticos", 18.00, 3));
        productos.add(new Producto(UUID.randomUUID(), "Anillo Vibrador", "Juguetes Eróticos", 30.00, 4));
        productos.add(new Producto(UUID.randomUUID(), "Juguete para Parejas", "Juguetes Eróticos", 40.00, 3));
        productos.add(new Producto(UUID.randomUUID(), "Funda para el Pene", "Accesorios", 22.00, 2));
    }

    // traer todos los datos
    public List<Producto> getProductos() {
        return productos;//retorna todos lo elementos de la clase
    }
    //retornar elemento
    public Optional<Producto> getProducto(UUID id) {
        return productos.stream().filter(producto -> producto.getId().equals(id)).findFirst();
    }
    //crear elemento
    public UUID CrearProducto(Producto producto) {
        //genera un ID aleatorio
        producto.setId(UUID.randomUUID());
        //agrega el elemento
        productos.add(producto);
        //retorna el id
        return producto.getId();
    }
    //actualizar elemento
    public Optional<Producto> actualizarProducto(UUID id, Producto productoActualizado) {
        Optional<Producto> existe = productos.stream().filter(producto -> producto.getId().equals(id)).findFirst();
        existe.ifPresent(producto -> {
            producto.setNombreProducto(productoActualizado.getNombreProducto());
            producto.setCategoriaProducto(productoActualizado.getCategoriaProducto());
            producto.setPrecioProducto(productoActualizado.getPrecioProducto());
            producto.setCantidad(productoActualizado.getCantidad());
        });
        return existe;
    }
    //borrar el registro
    public void eliminarProducto(UUID id) {
        //consulta por ID y se le elimina
        productos.removeIf(producto -> producto.getId().equals(id));
    }
}
