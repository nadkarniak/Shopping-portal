package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.ItemList;

public interface ItemListRepository extends CrudRepository<ItemList, Integer> {
}
