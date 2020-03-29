package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;

import edu.northeastern.cs5200.models.Product;
import edu.northeastern.cs5200.repositories.ProductRepository;

public class productDao {
  @Autowired
  ProductRepository productRepository;

  public boolean saveProduct(Product product) {
    productRepository.save(product);
    return true;
  }
}
