package com.salesianostriana.dam.proyectofinal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.salesianostriana.dam.proyectofinal.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	public List<Producto> findByNombreContainsIgnoreCase(String nombre);

	/**
	 * @Query("select p.id from Producto p") //quiero q coja los 3 primeros ids
	 * public List<Long> obtenerIds();
	 */

}
