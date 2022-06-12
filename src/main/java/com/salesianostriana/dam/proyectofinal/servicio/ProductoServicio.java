package com.salesianostriana.dam.proyectofinal.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.repository.ProductoRepository;
import com.salesianostriana.dam.proyectofinal.servicio.base.ServicioBaseImpl;

@Service
public class ProductoServicio extends
		ServicioBaseImpl<Producto, Long, ProductoRepository>{

	public ProductoServicio(ProductoRepository repositorio) {
		super(repositorio);
		// TODO Auto-generated constructor stub
	}
	
	public List<Long> recogerIdentificador(Optional<Producto> producto) {
		List<Long> listaIds = repositorio.obtenerIds();
		//listaIds<0>listaIds=  crear una lista con los tres primer ids de la lista 
		return listaIds;
	}
	



}