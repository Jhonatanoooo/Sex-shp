package com.taller.sexop.Controlador;

import com.taller.sexop.Entidad.Producto;
import com.taller.sexop.ProductService.ServiceProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
//se declara el controlador como Apirest
@RestController
//rusta de apires
@RequestMapping("/apiCRUD/v1/sexop")
public class ControllerProducto {
    @Autowired //servicio usado en el controlador
    private ServiceProducto serviceProducto;

    // lista de productos
    @GetMapping("/productos")
    public List<Producto> getProductos() {
        //metodo de retorno en la lista
        return serviceProducto.getProductos();
    }
    //elementos llamados por la consulta
    @GetMapping("/{id}")
    public Producto getProducto(@PathVariable UUID id) {
        //se busca el id del producto
        return serviceProducto.getProducto(id)
                .map(producto -> producto.getId().equals(id) ? producto : null)
                .orElse(null);
    }
    //elemento nuevo
    @PostMapping
    public ResponseEntity<String> createProducto(@RequestBody Producto producto) {
        UUID productoID = serviceProducto.CrearProducto(producto);
        return ResponseEntity.created(URI.create("/apiCRUD/v1/toyStory/" + productoID)).body("Juguete creado");
    }
    //elemento actualizado
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProducto(@PathVariable UUID id, @RequestBody Producto producto) {
        Optional<Producto> actualizar = serviceProducto.actualizarProducto(id, producto);
        return ResponseEntity.ok().body("actualizado");
    }
    //elemento eliminado
    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable UUID id) {
        serviceProducto.eliminarProducto(id);
    }
}
