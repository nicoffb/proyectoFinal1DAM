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

import com.salesianostriana.dam.proyectofinal.model.LineaVenta;
import com.salesianostriana.dam.proyectofinal.model.Venta;
import com.salesianostriana.dam.proyectofinal.servicio.LineaVentaServicio;
import com.salesianostriana.dam.proyectofinal.servicio.ProductoServicio;
import com.salesianostriana.dam.proyectofinal.servicio.VentaServicio;

import lombok.RequiredArgsConstructor;


	@Controller
	@RequestMapping("/lineas")
	public class LineaVentaController {
		
		
		@Autowired
		private LineaVentaServicio lineaventaServicio;
		
		@Autowired
		private VentaServicio ventaServicio;
	
	
		
		@GetMapping("/")
		public String listaVentas(Model model) {
			
			model.addAttribute("listaLineas", lineaventaServicio.findAll());
			
			// no se si cargarla desde aqui o desde el html Venta venta = ventaServicio.findById3(linea.id);
			return "lineas";
		}
		
		
		
		@GetMapping("/nuevaLinea")
		public String nuevaLinea(Model model) {
			model.addAttribute("linea", new LineaVenta());
			return "formularioLinea";
		}
		

		
		@PostMapping("/nuevaLinea/submit")
		public String submitNuevaLinea(@ModelAttribute("linea") LineaVenta linea, Model model) {
			
			lineaventaServicio.save(linea);
			
			//En el redirect hay que poner la ruta completa del controller al que queremos ir, 
			//incluyendo lo escrito dentro del @RequestMapping del comienzo de la clase
			//PORQUE ME DUPLICA LINEAS
			return "redirect:/lineas/";
		}
		
		
		@GetMapping("/editarLinea/{id}")
		public String editarLinea(@PathVariable("id") long id, Model model) {
			
			Optional<LineaVenta> resultado = lineaventaServicio.findById(id);
				
			if(resultado.isPresent())	{
				LineaVenta linea = resultado.get();
				model.addAttribute("linea", linea);
				return "formularioLinea";
			}else {
				return "redirect:/lineas/listaLineas";
			}
			
		}
		
		

		@GetMapping("/borrarLinea/{id}")
		public String borrarVenta(@PathVariable("id") Long id, Model model) {
			
			LineaVenta linea = lineaventaServicio.findById3(id);
			
			if (linea!= null) {
				
				if (lineaventaServicio != null) {
					lineaventaServicio.delete(linea);				
				} else {
					
				//Se ha agregado el parámetro error con valor true a la ruta	
					return "redirect:/lineas/";
				}
				
			} 

			return "redirect:/lineas/";
			
			
		}
				
		

}

