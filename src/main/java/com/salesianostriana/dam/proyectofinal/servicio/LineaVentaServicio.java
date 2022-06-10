package com.salesianostriana.dam.proyectofinal.servicio;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.LineaVenta;
import com.salesianostriana.dam.proyectofinal.repository.LineaVentaRepository;
import com.salesianostriana.dam.proyectofinal.servicio.base.ServicioBaseImpl;


@Service
public class LineaVentaServicio 
		extends ServicioBaseImpl<LineaVenta, Long, LineaVentaRepository>{
	
	
	public List<LineaVenta> listarPrimeros() {
		return this.repositorio.findAll()
				.stream()
				//.filter(c -> c.getNombre().startsWith("1º"))             debe recibir un videojuego o una Venta?
				.collect(Collectors.toList());
				
	}
	

}