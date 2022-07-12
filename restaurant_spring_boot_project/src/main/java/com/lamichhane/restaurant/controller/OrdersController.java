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

import com.lamichhane.restaurant.entity.CartProduct;
import com.lamichhane.restaurant.entity.Customer;
import com.lamichhane.restaurant.entity.Order;
import com.lamichhane.restaurant.model.OrderDemo;
import com.lamichhane.restaurant.service.AddressService;
import com.lamichhane.restaurant.service.CartProductService;
import com.lamichhane.restaurant.service.OrderService;

@RestController
@RequestMapping("/restaurant")
public class OrdersController {
	
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private CartProductService cartProductService;
	
//	@Autowired
//	private CustomerService customerService;
	
	
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
	public ResponseEntity<Order> saveOrder(@RequestBody OrderDemo order) {
		

		List<CartProduct> ingredients = order.getIngredients();
		double price = order.getTotalprice();
		Customer cust = order.getCustomer();
		
		Order orderdemo = new Order();
		orderdemo.setTotalprice(price);
		orderdemo.setCustomer(cust);
		
		
		for(CartProduct p : ingredients){
			orderdemo.add(p);
		}
		
		orderService.saveOrder(orderdemo);
		
		return new ResponseEntity<>(orderdemo,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/order")
	public Order updateOrder(@RequestBody Order order) {
		orderService.saveOrder(order);
		return order;
	}
	
	@DeleteMapping("/order/{orderId}")
	public String deleteOrder(@PathVariable int orderId) {
		Order order = orderService.getOrder(orderId);
		orderService.deleteOrder(orderId);
		
		return "Deleted Order  id is : "+orderId;
	}
	
	
}
