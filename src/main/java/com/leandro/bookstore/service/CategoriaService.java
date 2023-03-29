package com.leandro.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.bookstore.domain.Categoria;
import com.leandro.bookstore.dto.CategoriaDTO;
import com.leandro.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	CategoriaService(DBService dbservice) {
    }

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElse(null);

	}

	public List<Categoria> findAll() {
		return repository.findAll();
	}
	
	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
		
	}

	public Categoria update(Integer id, CategoriaDTO objDto) {
	  Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return repository.save(obj);
	}

	public void delete(Integer id) {
	   findById(id);
	   repository.deleteById(id);
		
	}

}
