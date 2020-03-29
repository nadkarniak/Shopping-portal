package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
