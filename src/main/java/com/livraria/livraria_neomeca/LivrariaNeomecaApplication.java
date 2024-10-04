package com.livraria.livraria_neomeca;

import java.util.Date;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.livraria.livraria_neomeca.controle_restart.RestartManager;
import com.livraria.livraria_neomeca.model.Autor;
import com.livraria.livraria_neomeca.model.Biblioteca;
import com.livraria.livraria_neomeca.model.Livro;

@SpringBootApplication
public class LivrariaNeomecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrariaNeomecaApplication.class, args);

		// Simulação do reinício
		System.out.println("");
		System.out.println("Reiniciando o ambiente...");
		System.out.println("");
		RestartManager.restartEnvironment();

		Scanner scanner = new Scanner(System.in);
		Biblioteca biblioteca = new Biblioteca();

		Autor autor1 = new Autor(1, "J.K. Rowling", new Date());
		Livro livro1 = new Livro(1, "Harry Potter e a Pedra Filosofal", autor1);
		biblioteca.adicionarLivro(livro1);

		Autor autor2 = new Autor(2, "George Orwell", new Date());
		Livro livro2 = new Livro(2, "1984", autor2);
		biblioteca.adicionarLivro(livro2);

		Autor autor3 = new Autor(3, "F. Scott Fitzgerald", new Date());
		Livro livro3 = new Livro(3, "O Grande Gatsby", autor3);
		biblioteca.adicionarLivro(livro3);

		Autor autor4 = new Autor(4, "Gabriel García Márquez", new Date());
		Livro livro4 = new Livro(4, "Cem Anos de Solidão", autor4);
		biblioteca.adicionarLivro(livro4);

		Autor autor5 = new Autor(5, "Harper Lee", new Date());
		Livro livro5 = new Livro(5, "O Sol É Para Todos", autor5);
		biblioteca.adicionarLivro(livro5);

		Autor autor6 = new Autor(6, "Jane Austen", new Date());
		Livro livro6 = new Livro(6, "Orgulho e Preconceito", autor6);
		biblioteca.adicionarLivro(livro6);

		Autor autor7 = new Autor(7, "Leo Tolstoy", new Date());
		Livro livro7 = new Livro(7, "Guerra e Paz", autor7);
		biblioteca.adicionarLivro(livro7);

		Autor autor8 = new Autor(8, "Franz Kafka", new Date());
		Livro livro8 = new Livro(8, "A Metamorfose", autor8);
		biblioteca.adicionarLivro(livro8);

		Autor autor9 = new Autor(9, "Mark Twain", new Date());
		Livro livro9 = new Livro(9, "As Aventuras de Tom Sawyer", autor9);
		biblioteca.adicionarLivro(livro9);

		Autor autor10 = new Autor(10, "Haruki Murakami", new Date());
		Livro livro10 = new Livro(10, "Kafka à Beira-Mar", autor10);
		biblioteca.adicionarLivro(livro10);

		boolean continuar = true;
		while (continuar) {
			System.out.println("Deseja ver os livros disponíveis? (S/N)");
			String resposta = scanner.nextLine();

			if (resposta.equalsIgnoreCase("S")) {
				System.out.println("Livros disponíveis:");
				for (Livro livro : biblioteca.listarLivrosDisponiveis()) {
					System.out.println(
							"ID: " + livro.getId() + " - Título: " + livro.getTitulo() + " - Autor: " + livro.getAutor().getNome());
				}

				System.out.print("Escolha o ID do livro para emprestar: ");
				int idLivro = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Informe seu nome: ");
				String nomeUsuario = scanner.nextLine();

				if (biblioteca.emprestarLivro(idLivro, nomeUsuario)) {
					System.out.println("O livro foi emprestado com sucesso!");
				} else {
					System.out.println("Livro não disponível ou ID inválido.");
				}
			} else {
				continuar = false;
				System.out.println("Fim da aplicação.");
			}
		}

		scanner.close();
	}
}
