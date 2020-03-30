package edu.northeastern.cs5200.models;



import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="shopping_cart")
public class ShoppingCart {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotNull
  private Date created;

  @NotNull
  private List<Product> listOfProducts;

  public ShoppingCart(){

  }


  public ShoppingCart(int id, @NotNull Date created, @NotNull List<Product> listOfProducts) {
    this.id = id;
    this.created = created;
    this.listOfProducts = listOfProducts;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public List<Product> getListOfProducts() {
    return listOfProducts;
  }

  public void setListOfProducts(List<Product> listOfProducts) {
    this.listOfProducts = listOfProducts;
  }
}