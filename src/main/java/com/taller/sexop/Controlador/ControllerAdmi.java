package com.taller.sexop.Controlador;

import com.taller.sexop.Entidad.Administrador;
import com.taller.sexop.Entidad.Clientes;
import com.taller.sexop.ProductService.ServiceAdmi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class ControllerAdmi {
    @Autowired
    private ServiceAdmi serviceAdmi;
    //historial de clientes
    @GetMapping("/listaClientes")
    public List<Clientes> listarClientes(){
        return serviceAdmi.listaClientes();
    }
    //historial de administradores
    @GetMapping("/listaAdmin")
    public List<Administrador> listarAdmin(){
        return serviceAdmi.getAdministradors();
    }
    //Administrador
    @PutMapping("/{id}")
    public Administrador AdminId(@PathVariable UUID id){
        return serviceAdmi.getAdministradorById(id).map(Administrador -> Administrador.getIdAdministrador().equals(id) ? Administrador : null).orElse(null);
    }
    //admmi
    @PostMapping
    public UUID crearAdministrador(@RequestBody Administrador admin){
        return serviceAdmi.insertAdministrador(admin.getNombre(),admin.getApellido(),admin.getCargo(),admin.getSalario());
    }
    //actualizacion de cada administrador
    @PutMapping("/actualizarAdmin/{id}")
    public boolean actualizarAdmin(@PathVariable UUID id, @RequestBody Administrador administrador) {
        return serviceAdmi.actualizarAdmin(
                id,
                administrador.getNombre(),
                administrador.getApellido(),
                administrador.getCargo(),
                administrador.getSalario()
        );
    }
    //eliminar admin
    @DeleteMapping("/borrarAdmin/{id}")
    public void borrarAdmin(@PathVariable UUID id) {
        serviceAdmi.eliminarAdministrador(id);
    }
}
