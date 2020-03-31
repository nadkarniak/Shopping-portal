package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;

import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.repositories.*;



public class userDao {

  @Autowired
  UserRepository userRepository;

  public boolean saveUser(User user) {
    userRepository.save(user);
    return true;
  }

}
