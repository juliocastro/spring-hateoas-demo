package com.juliocastro.hateoas.model;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class Author extends RepresentationModel<Author> implements Serializable {

  public Author(int id, String firstName, String lastName, String desc) {
    super();
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.desc = desc;
  }

  public Author() {}

  private static final long serialVersionUID = -8562829127684761196L; 
  private int id;
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  private String firstName, lastName, desc;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

}
