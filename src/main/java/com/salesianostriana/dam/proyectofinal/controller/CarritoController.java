package com.salesianostriana.dam.proyectofinal.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.servicio.CarritoServicio;
import com.salesianostriana.dam.proyectofinal.servicio.ProductoServicio;



@Controller
public class CarritoController {

	@Autowired
	private CarritoServicio carritoServicio;
	
	@Autowired
	private ProductoServicio productoServicio;
	
    @Autowired
    public CarritoController(CarritoServicio carritoServicio, ProductoServicio productoServicio) {
        this.carritoServicio = carritoServicio;
        this.productoServicio = productoServicio;
    }
    
    @GetMapping ("/carrito")
    public String mostrarCarrito (Model model) {
    	
    	if (model.addAttribute("products",carritoServicio.getProductsInCart()) == null)
    		return "redirect:/";
    	return "cart";
    }

    @GetMapping ("/productoACarrito/{id}")
    public String productoACarrito (@PathVariable("id") Long id, Model model) {
    	
    	carritoServicio.addProducto(productoServicio.findById(id).get());
    	    		 	
    	return "redirect:/carrito";
    }
    
    @GetMapping("/borrarProducto/{id}")
    public String removeProductFromCart(@PathVariable("id") Long id) {
        
    	carritoServicio.removeProducto(productoServicio.findById(id).get());
        return "redirect:/carrito";
    }
    
    @ModelAttribute("total_carrito")
    public Double totalCarrito () {
    	
    	Map <Producto,Integer> carrito=carritoServicio.getProductsInCart();
    	double total=0.0;
    	if (carrito !=null) {
        	for (Producto p: carrito.keySet()) {
        		total+=p.getPvp()*carrito.get(p);
        	}
        	return total;
    	}
    	
    	return 0.0;
    }
}
