package com.salesianostriana.dam.proyectofinal.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class LineaVenta {
	
	@ManyToOne
	private Producto videojuego;
	
	private int cantidad;
	private double precioUnitario;
	
	//esto debe estar aqui? una linea de venta crea un objeto venta?
	@ManyToOne
	private Venta venta;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	// Aqui deben estar los métodos helper de la asociación bidireccional entre Venta - LineaVenta
	
	public void sumarVenta(Venta venta) {
		this.venta = venta;
		venta.getLineas().add(this);
	}
	
	public void borrarVenta(Venta venta) {
		venta.getLineas().remove(this);
		this.venta = null;
	}
	
	//faltarian los de listado?
	

}
