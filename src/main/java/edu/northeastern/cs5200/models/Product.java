package edu.northeastern.cs5200.models;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="product")
public class Product {
  @NotNull
  private String name;

  @NotNull
  private String description;

  private Date manufactured;

  private Date expires;

  @NotNull
  private double price;

  public Product(){

  }

  public Product(String name, String description, Date manufactured, Date expires, double price) {
    this.name = name;
    this.description = description;
    this.manufactured = manufactured;
    this.expires = expires;
    this.price = price;
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

  public Date getExpires() {
    return expires;
  }

  public void setExpires(Date expires) {
    this.expires = expires;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
