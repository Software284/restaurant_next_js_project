package com.lamichhane.restaurant.service;
import java.util.List;

import com.lamichhane.restaurant.entity.Address;
import com.lamichhane.restaurant.entity.Order;

public interface OrderService {

	public List<Order> getAllOrder();
	   
	public void saveOrder(Order theOrder);

	public Order getOrder(int id);

	public void deleteOrder(int id);
}
