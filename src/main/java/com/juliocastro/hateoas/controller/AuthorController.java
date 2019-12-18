package com.juliocastro.hateoas.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juliocastro.hateoas.model.Author;
import com.juliocastro.hateoas.services.AuthorService;

@RestController
@RequestMapping("/api/author/v1")
public class AuthorController {

  @Autowired
  public AuthorService service;

  @GetMapping
  public List<Author> findAll() {
    List<Author> list = service.findAll();
    list.stream().forEach(
        a -> a.add(linkTo(methodOn(AuthorController.class).findById(a.getId())).withSelfRel()));
    return list;
  }

  @GetMapping(value = "{id}")
  public Author findById(@PathVariable("id") int id) {
    Author author = service.getById(id);
    if (author != null)
      author.add(linkTo(methodOn(AuthorController.class).findById(id)).withSelfRel());
    return author;
  }

}
