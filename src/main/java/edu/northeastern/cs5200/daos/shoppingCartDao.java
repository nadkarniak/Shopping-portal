package edu.northeastern.cs5200.daos;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

import edu.northeastern.cs5200.models.Product;
import edu.northeastern.cs5200.models.ShoppingCart;

@Service
@Transactional
public class shoppingCartDao {

  public List<Product> getListOfProducts(ShoppingCart shoppingCart) {
    return  shoppingCart.getListOfProducts();
  }

  public void addProductToCart(Product product) {

  }

}
