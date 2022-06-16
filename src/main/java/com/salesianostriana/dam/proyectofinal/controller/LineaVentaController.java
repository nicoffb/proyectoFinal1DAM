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
		
		@Autowired
		private ProductoServicio productoServicio;
	
	
		
		@GetMapping("/")
		public String listaVentas(Model model) {
			
			model.addAttribute("listaLineas", lineaventaServicio.findAll());
			
			// no se si cargarla desde aqui o desde el html Venta venta = ventaServicio.findById3(linea.id);
			return "lineas";
		}
		
		
		
		@GetMapping("/nuevaLinea/{id}")
		public String nuevaLinea(@PathVariable("id") long id, Model model) {
			LineaVenta nuevaLinea = new LineaVenta();
			nuevaLinea.setVenta(ventaServicio.findById(id).get());
			model.addAttribute("linea", nuevaLinea);
			model.addAttribute("videojuegos", productoServicio.findAll());
			return "formularioLinea";
		}
		

		
		@PostMapping("/nuevaLinea/submit")
		public String submitNuevaLinea(@ModelAttribute("linea") LineaVenta linea, Model model) {
			linea.setPrecioUnitario(lineaventaServicio.CalcularSubtotal(linea));
			lineaventaServicio.save(linea);
			linea.getVenta().setPrecioTotal(ventaServicio.CalcularTotalVenta(linea.getVenta()));
			ventaServicio.save(linea.getVenta());
			
			//En el redirect hay que poner la ruta completa del controller al que queremos ir, 
			//incluyendo lo escrito dentro del @RequestMapping del comienzo de la clase
			//PORQUE ME DUPLICA LINEAS
			return "redirect:/editarVenta/" + linea.getVenta().getId();
		}
		
		
		@GetMapping("/editarLinea/{id}")
		public String editarLinea(@PathVariable("id") long id, Model model) {
			
			Optional<LineaVenta> resultado = lineaventaServicio.findById(id);
				
			if(resultado.isPresent())	{
				LineaVenta linea = resultado.get();
				model.addAttribute("linea", linea);
				model.addAttribute("videojuegos", productoServicio.findAll());
				return "formularioLinea";
			}else {
				return "redirect:/editarVenta/";
			}
			
		}
		
		

		@GetMapping("/borrarLinea/{id}")
		public String borrarVenta(@PathVariable("id") Long id, Model model) {
			
			Optional<LineaVenta> linea = lineaventaServicio.findById(id);
			
			if (linea.isPresent()) {
					lineaventaServicio.deleteById(id);
					return "redirect:/editarVenta/" + linea.get().getVenta().getId();
				} else {
					
				    return "redirect:/lineas/";
				}
				
		    }
				
		

		}
