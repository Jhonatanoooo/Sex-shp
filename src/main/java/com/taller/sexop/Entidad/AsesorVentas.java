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
//espesifdicaciones de asesores de ventas
public class AsesorVentas {
    private UUID idAsesor;
    private String nombre;
    private String apellido;
    private String cargo;
    private float salario;
}
