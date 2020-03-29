package edu.northeastern.cs5200.models;


import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "item_list")
public class ItemList {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotNull
  private String name;

  @NotNull
  @ManyToOne
  @JoinColumn(name="id")
  private User supplier;

  public ItemList(){

  }
  public ItemList(int id, String name, User supplier){
    this.id = id;
    this.name = name;
    this.supplier = supplier;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User getSupplier() {
    return supplier;
  }

  public void setSupplier(User supplier) {
    this.supplier = supplier;
  }

}
