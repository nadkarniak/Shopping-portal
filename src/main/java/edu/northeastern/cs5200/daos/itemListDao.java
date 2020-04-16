package edu.northeastern.cs5200.daos;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import edu.northeastern.cs5200.models.ItemList;
import edu.northeastern.cs5200.repositories.ItemListRepository;

public class itemListDao {
  @Autowired
  ItemListRepository itemListRepository;

  public boolean saveUser(ItemList itemList) {
    itemListRepository.save(itemList);
    return true;
  }

  public List<ItemList> findAllLists(){
    return (List<ItemList>) itemListRepository.findAll();
  }
}
