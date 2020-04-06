package edu.northeastern.cs5200.models;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="product")
public class Product {

  @Id
  private long id;

  @NotNull
  private String name;

  @NotNull
  private String brand;

  @NotNull
  private String madein;

  @NotNull
  private String description;


  @NotNull
  private Date manufactured;

  @NotNull
  private double price;

  @ManyToOne
  private ShoppingCart shoppingCart;

  public Product(){

  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getMadein() {
    return madein;
  }

  public void setMadein(String madein) {
    this.madein = madein;
  }

  public ShoppingCart getShoppingCart() {
    return shoppingCart;
  }

  public void setShoppingCart(ShoppingCart shoppingCart) {
    this.shoppingCart = shoppingCart;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getManufactured() {
    return manufactured;
  }

  public void setManufactured(Date manufactured) {
    this.manufactured = manufactured;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
