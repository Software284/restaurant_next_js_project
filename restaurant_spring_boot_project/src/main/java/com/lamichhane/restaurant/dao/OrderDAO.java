package com.lamichhane.restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lamichhane.restaurant.entity.Order;

@Repository
public interface OrderDAO extends JpaRepository<Order,Integer> {

}
