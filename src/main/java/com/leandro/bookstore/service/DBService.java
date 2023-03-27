package com.leandro.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.bookstore.domain.Categoria;
import com.leandro.bookstore.domain.Livro;
import com.leandro.bookstore.repositories.CategoriaRepository;
import com.leandro.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBasedeDados() {

		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ficção Cientifica", "Ficção Cientifica");
		Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografia");

		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Robert maria", "lorem ipsum", cat1);
		Livro l3 = new Livro(null, "Time Machine", "Robert Almeida", "lorem ipsum", cat2);
		Livro l4 = new Livro(null, "Guerra dos Mundos ", "Robert leitão", "lorem ipsum", cat2);
		Livro l5 = new Livro(null, "I, Robot", "Robert Vitorino", "lorem ipsum", cat2);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));

		categoriaRepository.saveAllAndFlush(Arrays.asList(cat1, cat2, cat3));
		livroRepository.saveAllAndFlush(Arrays.asList(l1, l2, l3, l4, l5));

	}

}
