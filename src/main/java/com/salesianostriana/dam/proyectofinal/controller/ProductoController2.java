//package com.salesianostriana.dam.proyectofinal.controller;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import com.salesianostriana.dam.proyectofinal.model.Producto;
//import com.salesianostriana.dam.proyectofinal.servicio.ProductoServicio;
//
//
//@Controller
//@RequestMapping("/producto")
//public class ProductoController2 {
//	
//	@Autowired
//	private ProductoServicio productoServicio;
//	
//	@GetMapping("/hola")
//	public String list(Model model) {
//		model.addAttribute("lista", productoServicio.findAll());
//		return "producto/index";
//	}
//	
//	@GetMapping("/detalle/{id}")
//	public String detail(Model model, @PathVariable Long id) {
//		
//		Optional<Producto> result = productoServicio.findById(id);
//		
//		if (result.isPresent()) {
//			model.addAttribute("producto", result.get());
//			return "producto/detail";			
//		} else {
//			return "redirect:/producto/";
//		}
//		
//	}
//	
//	
//	//METODO PARA LOGIN
//	@GetMapping("/nuevo")
//	public String mostrarFormulario(Model model) {
//		model.addAttribute("producto", new Producto());
//		return "login";
//	}
//
//	/*
//	@PostMapping("/nuevo/submit")
//	public String procesarFormulario(@ModelAttribute("producto") Producto p) {
//		productoServicio.add(p);
//		return "redirect:/";//Podría ser también return "redirect:/list
//	}
//	*/
//	
//	
//
//}