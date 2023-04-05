package com.leandro.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.bookstore.domain.Livro;
import com.leandro.bookstore.repositories.LivroRepository;
import com.leandro.bookstore.service.exeptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado!"));

	}

	public List<Livro> findAll() {
		return repository.findAll();
	}
	
	public Livro create(Livro obj) {
		obj.setId(null);
		return repository.save(obj);

	}


}
