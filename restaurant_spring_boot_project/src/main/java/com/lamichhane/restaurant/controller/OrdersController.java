package com.lamichhane.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lamichhane.restaurant.entity.Order;
import com.lamichhane.restaurant.entity.Product;
import com.lamichhane.restaurant.service.AddressService;
import com.lamichhane.restaurant.service.CartProductService;
import com.lamichhane.restaurant.service.OrderService;

@RestController
@RequestMapping("/restaurant")
public class OrdersController {
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private CartProductService cartProductService;
	
	@Autowired
	private OrderService orderService;
	
	
	@GetMapping("/order")
	public List<Order> getAllOrder() {
		return orderService.getAllOrder();
	}
	
	@GetMapping("/order/{orderId}")
	public Order getOrder(@PathVariable int orderId) {
		Order order = orderService.getOrder(orderId);
		return order;
	}
	
	
	@PostMapping("/order")
	public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
		orderService.saveOrder(order);
		return new ResponseEntity<>(order,HttpStatus.CREATED);
	}
	
	@PutMapping("/product")
	public Order updateOrder(@RequestBody Order order) {
		orderService.saveOrder(order);
		return order;
	}
	
	@DeleteMapping("/product/{productId}")
	public String deleteOrder(@PathVariable int orderId) {
		Order order = orderService.getOrder(orderId);
		orderService.deleteOrder(orderId);
		
		return "Deleted Order  id is : "+orderId;
	}
	
	
}
