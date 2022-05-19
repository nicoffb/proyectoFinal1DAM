package com.salesianostriana.dam.proyectofinal.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {
	
	
	private String nombre;
	@Lob
	private String descripcion;
	private String imagen;
	private float pvp;
	private float descuento;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
		
	
	
}
