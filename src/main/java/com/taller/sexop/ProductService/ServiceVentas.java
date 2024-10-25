package com.taller.sexop.ProductService;

import com.taller.sexop.Entidad.Ventas;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceVentas {
    private List<Ventas> listaVentas = new ArrayList<>();;

    //ventas
    public List<Ventas> getVentas() {
        return listaVentas;
    }

    //venta
    public void agregarVenta(Ventas ventas) {
        //agregar cliente
        listaVentas.add(ventas);
    }
}
