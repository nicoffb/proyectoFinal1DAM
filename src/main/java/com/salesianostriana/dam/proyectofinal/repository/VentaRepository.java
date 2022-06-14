package com.salesianostriana.dam.proyectofinal.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{
	
	public List<Producto> findByCompradorContainingIgnoreCase(String comprador);
	
	
} 
