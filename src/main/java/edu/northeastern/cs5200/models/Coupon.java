package edu.northeastern.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "coupon")
public class Coupon {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String description;

  private String productName;

  private DiscountType dType;

  private int couponCode;

  @ManyToOne
  private Buyer buyerCoupon;

  public Coupon(){
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getCouponCode() {
    return couponCode;
  }

  public void setCouponCode(int couponCode) {
    this.couponCode = couponCode;
  }

  public Buyer getBuyerCoupon() {
    return buyerCoupon;
  }

  public void setBuyerCoupon(Buyer buyerCoupon) {
    this.buyerCoupon = buyerCoupon;
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
