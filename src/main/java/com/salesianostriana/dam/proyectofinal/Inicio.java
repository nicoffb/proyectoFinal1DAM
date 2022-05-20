package com.salesianostriana.dam.proyectofinal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.repository.LineaVentaRepository;
import com.salesianostriana.dam.proyectofinal.repository.ProductoRepository;

@Component
public class Inicio {
	@Autowired
	private  ProductoRepository productoRepository;
	@Autowired
	private  LineaVentaRepository lineaVentaRepository;

/*
	@PostConstruct

	public void run() {
		
		Producto p = Producto.builder()
				.descripcion("NENENE")
				.nombre("god of war")
				.build();
		productoRepository.save(p);
		
	}
	*/
}

		