package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coupon")
public class Coupon {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String description;

  private DiscountType dType;

  //coupon for the particular product
  private Product productCoupon;

  public Coupon(){
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public DiscountType getdType() {
    return dType;
  }

  public void setdType(DiscountType dType) {
    this.dType = dType;
  }

  public Product getProductCoupon() {
    return productCoupon;
  }

  public void setProductCoupon(Product productCoupon) {
    this.productCoupon = productCoupon;
  }



  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public DiscountType getDtype() {
    return dType;
  }

  public void setDtype(DiscountType dtype) {
    this.dType = dtype;
  }
}
