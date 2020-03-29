package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;

import edu.northeastern.cs5200.models.ItemList;
import edu.northeastern.cs5200.repositories.ItemListRepository;

public class itemListDao {
  @Autowired
  ItemListRepository itemListRepository;

  public boolean saveUser(ItemList itemList) {
    itemListRepository.save(itemList);
    return true;
  }
}
