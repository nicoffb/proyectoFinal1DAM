package com.salesianostriana.dam.proyectofinal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectofinal.model.Venta;
import com.salesianostriana.dam.proyectofinal.servicio.LineaVentaServicio;
import com.salesianostriana.dam.proyectofinal.servicio.ProductoServicio;
import com.salesianostriana.dam.proyectofinal.servicio.VentaServicio;

import lombok.RequiredArgsConstructor;


	@Controller
	@RequiredArgsConstructor
	public class VentaController {
		
		
		@Autowired
		private LineaVentaServicio lineaventaServicio;
		
		@Autowired
		private VentaServicio ventaServicio;
	
		
		@GetMapping("/listaVentas")
		public String listaVentas(Model model) {
			
			model.addAttribute("listaVentas", ventaServicio.findAll());
			return "ventas";
		}
		
		
		
		@GetMapping("/nuevaVenta")
		public String nuevaVenta(Model model) {
			model.addAttribute("venta", new Venta());
			return "formularioVenta";
		}
		

		
		@PostMapping("/nuevaVenta/submit")
		public String submitNuevaVenta(@ModelAttribute("venta") Venta venta, Model model) {
			
			ventaServicio.save(venta);
			
			//En el redirect hay que poner la ruta completa del controller al que queremos ir, 
			//incluyendo lo escrito dentro del @RequestMapping del comienzo de la clase
			return "redirect:/listaVentas/";
		}
		
		
		@GetMapping("/editarVenta/{id}")
		public String editarVenta(@PathVariable("id") long id, Model model) {                            
			
			Venta venta = ventaServicio.findById2(id);
			
			if (venta != null) {
				model.addAttribute("venta", venta);
				model.addAttribute("listaLineas", venta.getLineas());
				return "lineas";
			} else {
				return "redirect:/listaVenta";
			}
			
		}
		//58 es la que tiene 2 lineas
		

		@GetMapping("/borrarVenta/{id}")
		public String borrarVenta(@PathVariable("id") Long id, Model model) {
			
			Venta venta = ventaServicio.findById2(id);
			
			if (venta!= null) {
				
				if (ventaServicio != null) {
					ventaServicio.delete(venta);				
				} else {
					
				//Se ha agregado el parámetro error con valor true a la ruta	
					return "redirect:/listaVentas";
				}
				
			} 

			return "redirect:/listaVentas";
			
			
		}
				
		

}

