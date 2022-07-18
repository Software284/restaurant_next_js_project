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
import com.lamichhane.restaurant.service.CustomerService;
import com.lamichhane.restaurant.service.OrderService;
import com.lamichhane.restaurant.success.classes.StandardRestSuccessResponse;

@RestController
@RequestMapping("/restaurant")
public class OrdersController {
	
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private CartProductService cartProductService;
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/order")
	public List<Order> getAllOrder() {
      List<Order> list = orderService.getAllOrder();
      System.out.println(list.get(0).getCartdata().toString());
      return list;
	}
	
	@GetMapping("/order/{orderId}")
	public Order getOrder(@PathVariable int orderId) {
		Order order = orderService.getOrder(orderId);
		return order;
	}
	
	
	@PostMapping("/order")
	public ResponseEntity<?> saveOrder(@RequestBody OrderDemo order) {
		

		List<CartProduct> ingredients = order.getIngredients();
		int price = order.getTotalprice();
		Customer cust = order.getCustomer();

		Order orderdemo = new Order();
		orderdemo.setTotalprice(price);
		orderdemo.setCustomer(cust);
		
		
		for(CartProduct p : ingredients){
			orderdemo.add(p);
		}
		
		orderService.saveOrder(orderdemo);
		
		StandardRestSuccessResponse response = new StandardRestSuccessResponse();
		response.setMessage("Order Saved Successfully");
		response.setStatus("success");
		response.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(response,HttpStatus.CREATED);
		
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
