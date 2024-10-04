package com.livraria.livraria_neomeca.model;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
  private List<Livro> livros = new ArrayList<>();
  private List<Emprestimo> emprestimos = new ArrayList<>();

  public void adicionarLivro(Livro livro) {
    livros.add(livro);
  }

  public List<Livro> listarLivrosDisponiveis() {
    List<Livro> disponiveis = new ArrayList<>();
    for (Livro livro : livros) {
      if (livro.isDisponivel()) {
        disponiveis.add(livro);
      }
    }
    return disponiveis;
  }

  public boolean emprestarLivro(int idLivro, String nomeUsuario) {
    for (Livro livro : livros) {
      if (livro.getId() == idLivro && livro.isDisponivel()) {
        livro.setDisponivel(false);
        emprestimos.add(new Emprestimo(livro, nomeUsuario));
        return true;
      }
    }
    return false;
  }
}
