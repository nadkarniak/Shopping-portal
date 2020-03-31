package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

import edu.northeastern.cs5200.models.Product;
import edu.northeastern.cs5200.repositories.ProductRepository;

@Service
@Transactional
public class productDao {
  @Autowired
  ProductRepository productRepository;

  public boolean saveProduct(Product product) {
    productRepository.save(product);
    return true;
  }

  public List<Product> listAll() {
    return (List<Product>) productRepository.findAll();
  }
}
