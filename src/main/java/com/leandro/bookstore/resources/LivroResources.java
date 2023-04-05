package com.leandro.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.leandro.bookstore.domain.Livro;
import com.leandro.bookstore.dto.LivroDTO;
import com.leandro.bookstore.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResources {

	@Autowired
	private LivroService service;

	// método buscar por id (findById)

	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id) {
		Livro obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}

	// metodo lista todos (findAll)

	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll() {
		List<Livro> list = service.findAll();
		List<LivroDTO> listdto = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listdto);
	}

	
	
	// metodo para salvar (save)
	 
	 @PostMapping
	 public ResponseEntity<Livro> create(@RequestBody Livro obj) {
			obj = service.create(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();

	 }	 
		 
}

