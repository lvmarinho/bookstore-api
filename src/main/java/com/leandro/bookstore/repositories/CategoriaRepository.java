package com.leandro.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leandro.bookstore.domain.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
	

}
