package com.leandro.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leandro.bookstore.domain.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
	public List<Categoria> findAll();
		
	}
	
	


