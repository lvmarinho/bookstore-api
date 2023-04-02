package com.leandro.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;

import com.leandro.bookstore.domain.Livro;

public interface LivroRepository extends CrudRepository<Livro, Integer> {

}
