package com.leandro.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leandro.bookstore.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
	

}
