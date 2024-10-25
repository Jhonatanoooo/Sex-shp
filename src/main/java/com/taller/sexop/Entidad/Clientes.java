package com.taller.sexop.Entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Clientes {
    private UUID idCliente;
    private int ccCliente;
    private String nombre;
    private String apellido;
    private String telefono;
}
