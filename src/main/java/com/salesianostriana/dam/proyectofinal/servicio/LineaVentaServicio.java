package com.salesianostriana.dam.proyectofinal.servicio;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.LineaVenta;
import com.salesianostriana.dam.proyectofinal.repository.LineaVentaRepository;
import com.salesianostriana.dam.proyectofinal.servicio.base.ServicioBaseImpl;


@Service
public class LineaVentaServicio 
		extends ServicioBaseImpl<LineaVenta, Long, LineaVentaRepository>{
	
	
	public LineaVentaServicio(LineaVentaRepository repositorio) {
		super(repositorio);
		// TODO Auto-generated constructor stub
	}

	public List<LineaVenta> listarPrimeros() {
		return this.repositorio.findAll()
				.stream()
				//.filter(c -> c.getNombre().startsWith("1º"))             debe recibir un videojuego o una Venta?
				.collect(Collectors.toList());
				
	}
	
	
	/**
	 * 
	 * @param l
	 * @return
	 */
	public double CalcularSubtotal (LineaVenta l) {
		double precioConDescuento= 0;
		double numProdPromo = 0;
		boolean promo = false;
		//numero de productos que van a ser gratis
		if(l.getCantidad()/4 >= 1) {
			numProdPromo =  l.getCantidad()/4;
			numProdPromo = Math.floor(numProdPromo);
			promo = true;
		}
		
		precioConDescuento += (l.getVideojuego().getPvp())*(1-l.getVideojuego().getDescuento()/100)*l.getCantidad();
		
		//le quitamos el precio de tantos productos que le correspondan
		if(promo) {
			precioConDescuento -= numProdPromo*((l.getVideojuego().getPvp())*(1-l.getVideojuego().getDescuento()/100));
		}
		
		l.setPrecioUnitario(precioConDescuento);
		return precioConDescuento;
	}
	

}