package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Buyer extends User {

  // shopping cart of the buyer
  private ShoppingCart shoppingCartOfBuyer;

  @OneToMany(mappedBy = "buyerCoupon")
  private List<Coupon> couponList;

  public Buyer() {
    super();
  }


  public ShoppingCart getShoppingCartOfBuyer() {
    return shoppingCartOfBuyer;
  }

  public void setShoppingCartOfBuyer(ShoppingCart shoppingCartOfBuyer) {
    this.shoppingCartOfBuyer = shoppingCartOfBuyer;
  }

  public List<Coupon> getCouponList() {
    return couponList;
  }

  public void setCouponList(List<Coupon> couponList) {
    this.couponList = couponList;
  }
}
