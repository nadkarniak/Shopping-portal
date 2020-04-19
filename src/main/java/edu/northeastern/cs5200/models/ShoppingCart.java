package edu.northeastern.cs5200.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.sql.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import edu.northeastern.cs5200.modelHelpers.UserLogin;


@Entity
@Table(name="shopping_cart")
public class ShoppingCart {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;


  private Date created;


  //buyer of the shopping cart
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(unique = true)
  private Buyer buyerCart;

  @OneToMany(mappedBy = "shoppingCart")
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<Product> listOfProducts;

  public ShoppingCart(){
  }

  // set the buyer for this shopping cart and add the products to the shopping cart
  public void AddProductToShoppingCart(Product product) {
    this.listOfProducts.add(product);
    if (product.getShoppingCart() != this)
      product.setShoppingCart(this);
  }

  public Buyer getBuyerCart() {
    return buyerCart;
  }

  public void setBuyerCart(Buyer buyerCart) {
    this.buyerCart = buyerCart;
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
    return this.listOfProducts;
  }

  public void setListOfProducts(List<Product> listOfProducts) {
    this.listOfProducts = listOfProducts;
  }
}
