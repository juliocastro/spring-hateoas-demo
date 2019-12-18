package com.juliocastro.hateoas.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.juliocastro.hateoas.model.Author;

@Service
public class AuthorService {
  private List<Author> authors = new ArrayList<Author>();

  public List<Author> findAll() {
    return makeAll(10);
  }

  public Author getById(int id) {
    return authors.stream().filter(a -> a.getId() == id).findAny().orElse(null);
  }

  private Author makeAuthor(int id) {
    return new Author(id, "Nome" + id, "Sobrenome" + id, "Gerado automaticamente com o id " + id);

  }

  private List<Author> makeAll(int quantity) {
    for (int i = 0; i < quantity; i++) {
      authors.add(makeAuthor(i));
    }
    return authors;
  }

}
