package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import edu.northeastern.cs5200.models.Order;
import edu.northeastern.cs5200.repositories.OrderRepository;

public class orderDao {

  @Autowired
  OrderRepository orderRepository;

  public boolean saveOrder(Order order) {
    orderRepository.save(order);
    return true;
  }

  public List<Order> findAllOrders(){
    return (List<Order>) orderRepository.findAll();
  }
}
