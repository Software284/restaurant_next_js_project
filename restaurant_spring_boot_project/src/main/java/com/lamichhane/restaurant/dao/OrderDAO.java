package com.lamichhane.restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lamichhane.restaurant.entity.Order;

public interface OrderDAO extends JpaRepository<Order,Integer> {

}
