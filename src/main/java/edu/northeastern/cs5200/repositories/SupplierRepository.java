package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
}
