package com.salesianostriana.dam.proyectofinal.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

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
	
	
	@ManyToOne
	private Venta venta;
	
	@Id
	@SequenceGenerator(initialValue=500, 
	                   		allocationSize=1,
	                        name = "id", 
	                        sequenceName="id")
	@GeneratedValue(generator="id")
	private long id;
	
	// Métodos helper de la asociación bidireccional entre Venta - LineaVenta
	
	public void sumarVenta(Venta venta) {
		this.venta = venta;
		venta.getLineas().add(this);
	}
	
	public void borrarVenta(Venta venta) {
		venta.getLineas().remove(this);
		this.venta = null;
	}
	
	

}
