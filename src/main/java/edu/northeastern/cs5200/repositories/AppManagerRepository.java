package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.AppManager;

public interface AppManagerRepository extends CrudRepository<AppManager, Long> {
}
