package com.salesianostriana.dam.proyectofinal.servicio.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinal.model.LineaVenta;
import com.salesianostriana.dam.proyectofinal.model.Venta;

public abstract class ServicioBaseImpl<T, ID, R extends JpaRepository<T, ID>> implements ServicioBase<T, ID> {

	
	protected R repositorio;
	
	public ServicioBaseImpl (R repositorio) {
		this.repositorio=repositorio;
	}
	
	
	@Override
	public T save(T t) {
		return repositorio.save(t);
	}
	
	public List<T> saveAll(List<T> list){
		return repositorio.saveAll(list);
	}

	@Override
	public Optional<T> findById(ID id) {
		return repositorio.findById(id);
	}
	
	
	@Override
	public List<T> findAll() {
		return repositorio.findAll();
	}

	@Override
	public T edit(T t) {
		return repositorio.save(t);
	}

	@Override
	public void delete(T t) {
		repositorio.delete(t);
	}

	@Override
	public void deleteById(ID id) {
		repositorio.deleteById(id);
	}
	
	public Venta findById2(Long id) {
		return (Venta) repositorio.findById((ID) id).orElse(null);
	}
	
	public LineaVenta findById3(Long id) {
		return (LineaVenta) repositorio.findById((ID) id).orElse(null);
	}
	
	

}