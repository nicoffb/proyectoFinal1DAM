//package com.salesianostriana.dam.proyectofinal.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.salesianostriana.dam.proyectofinal.model.Producto;
//import com.salesianostriana.dam.proyectofinal.servicio.ProductoServicio;
//
//public class ProductoController3 {
///*	
//	@Autowired
//	private ProductoServicio productoServicio;
//
//	@GetMapping({"/","/index"})
//	public String index(Model model, @RequestParam("q") Optional<String> consulta) {
//
//		List<Producto> productos = new ArrayList<>();
//		if (consulta.isEmpty()) {
//			for (Producto producto : productoServicio.findAll()) {
//				productos.add(producto);
//
//			}
//			model.addAttribute("producto", productos);
//
//		}
//		return "index";
//	}
//	
//	
//	@GetMapping("/eliminar/{id}")
//	public String eliminar(@PathVariable("id") Long id, Model model) {
//		Producto p = productoServicio.findById(id);
//		productoServicio.delete(p);
//		return "redirect:/";
//	}
//	@GetMapping("/editar/{id}")
//	public String editar(@PathVariable("id") Long id, Model model) {
//		Producto p = productoServicio.findById(id);
//		model.addAttribute(p);
//
//		return "formularioperro";
//	}
//	
//	
//	@PostMapping({ "/submit", "/submit/{id}" })
//	public String procesaFormulario(@ModelAttribute("producto") Producto producto) {
//		
//		productoServicio.save(producto);
//		return "redirect:/";
//	}
//	*/
//
//}
