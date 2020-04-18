package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.modelHelpers.UserLogin;

public interface LoginRepository extends CrudRepository<UserLogin, Long> {
}
