package com.lamichhane.restaurant.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lamichhane.restaurant.dao.OrderDAO;
import com.lamichhane.restaurant.entity.Address;
import com.lamichhane.restaurant.entity.Order;
import com.lamichhane.restaurant.exception.classes.AddressNotFoundException;



@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDAO orderDAO;

	
	@Override
	@Transactional
	public List<Order> getAllOrder() {
		
		return orderDAO.findAll();
	}

	@Override
	@Transactional
	public void saveOrder(Order theOrder) {
		orderDAO.save(theOrder);
	}

	@Override
	@Transactional
	public Order getOrder(int theId) {
		Optional<Order> order = orderDAO.findById(theId);
		if(order.isEmpty()) {
			throw new AddressNotFoundException("Address Not Found With Id-"+theId);
		}
		return order.get();
		
	}

	@Override
	@Transactional
	public void deleteOrder(int id) {
		orderDAO.deleteById(id);
	}
	
}
