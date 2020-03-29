package edu.northeastern.cs5200.models;

public class Coupon {

  public String description;


  public DiscountType dtype;

  public Coupon(){

  }


  public Coupon(String description, DiscountType dtype) {
    this.description = description;
    this.dtype = dtype;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public DiscountType getDtype() {
    return dtype;
  }

  public void setDtype(DiscountType dtype) {
    this.dtype = dtype;
  }
}
