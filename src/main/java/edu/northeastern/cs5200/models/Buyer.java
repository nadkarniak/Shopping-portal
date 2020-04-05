package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Buyer extends User {

  private int credit;

  @OneToMany(mappedBy = "buyerCart")
  private List<ShoppingCart> shoppingCartList;

  public Buyer() {
    super();
  }


  public int getCredit() {
    return credit;
  }

  public void setCredit(int credit) {
    this.credit = credit;
  }

}
