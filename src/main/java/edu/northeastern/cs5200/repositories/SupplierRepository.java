package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {

  @Query("SELECT supplier FROM Supplier supplier WHERE supplier.userName = :username ")
  public Supplier findSupplierByUsername(@Param("username") String userName);
}
