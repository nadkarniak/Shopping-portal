package edu.northeastern.cs5200.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="order")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotNull
  private Date ordered;

  private Date shipped;

  private OrderStatus status;

  public Order(){

  }

  public Order(int id, @NotNull Date ordered, Date shipped, OrderStatus status) {
    this.id = id;
    this.ordered = ordered;
    this.shipped = shipped;
    this.status = status;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getOrdered() {
    return ordered;
  }

  public void setOrdered(Date ordered) {
    this.ordered = ordered;
  }

  public Date getShipped() {
    return shipped;
  }

  public void setShipped(Date shipped) {
    this.shipped = shipped;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }
}
