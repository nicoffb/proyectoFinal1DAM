package com.salesianostriana.dam.proyectofinal.servicio.base;

import java.util.List;
import java.util.Optional;

public interface ServicioBase<T, ID> {
	
	
	T save(T t);

	Optional<T> findById(ID id);

	List<T> findAll();

	T edit(T t);

	void delete(T t);

	void deleteById(ID id);
	

}