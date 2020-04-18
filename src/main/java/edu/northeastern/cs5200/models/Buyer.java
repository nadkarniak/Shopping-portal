package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Buyer extends User {

  // shopping cart of the buyer
  @OneToOne(mappedBy = "buyerCart")
  private ShoppingCart shoppingCartOfBuyer;

  @OneToMany(mappedBy = "buyerCoupon")
  private List<Coupon> couponList;

  public Buyer() {
    super();
  }

  //add the coupon and set the buyer for the coupon
  public void addCouponToBuyer(Coupon coupon) {
    couponList.add(coupon);
    if(coupon.getBuyerCoupon() != this) {
      coupon.setBuyerCoupon(this);
    }
  }


   ShoppingCart getShoppingCartOfBuyer() {
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
