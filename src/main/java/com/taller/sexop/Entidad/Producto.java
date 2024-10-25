package com.taller.sexop.Entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
//libreria demetodos  get y set
@Data
//premite crear todos los parametros
@AllArgsConstructor
@Getter
@Setter
//espesificaciondes del producto
public class Producto {
    private UUID id;
    private String nombreProducto;
    private String categoriaProducto;
    private double precioProducto;
    private int cantidad;
}
