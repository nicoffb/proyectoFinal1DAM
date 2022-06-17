package com.salesianostriana.dam.proyectofinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

	public List<Producto> findByCompradorContainingIgnoreCase(String comprador);

	
	/**
	 * 
	 * Usamos esta consulta para obtener el total recaudado del mes en el que nos encontramos en la lista de ventas
	 */
	@Query("SELECT COALESCE( SUM(v.precioTotal) , 0)FROM Venta v WHERE MONTH(v.fechaCompra) = MONTH(current_date) AND YEAR(v.fechaCompra) = YEAR(current_date)")
	public double totalRecaudadoMes();

}








//hay que ponerle alias obligatoriamente al query