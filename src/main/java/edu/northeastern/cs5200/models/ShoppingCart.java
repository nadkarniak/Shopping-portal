package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

  //buyer of the shopping cart
  private Buyer buyerCart;

  @OneToMany(mappedBy = "shoppingCart")
  private List<Product> listOfProducts;

  public ShoppingCart(){
  }

  // set the buyer for this shopping cart and add the products to the shopping cart
  public void AddProductToShoppingCart(Product product) {
    listOfProducts.add(product);
    if(buyerCart.getShoppingCartOfBuyer() != this) {
      buyerCart.setShoppingCartOfBuyer(this);
    }
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
