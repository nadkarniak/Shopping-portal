package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

  @Query("delete from Product product where product.id=:id")
  void deleteProductById(@Param("id") int id);



  @Query("SELECT product FROM Product product WHERE product.id =: id")
  Product findProductById(@Param("id") long id);
}
