package com.livraria.livraria_neomeca.model;

import java.util.Date;

import lombok.Data;

@Data
public class Emprestimo {
  private Livro livro;
  private String nomeUsuario;
  private Date dataEmprestimo;

  public Emprestimo(Livro livro, String nomeUsuario) {
    this.livro = livro;
    this.nomeUsuario = nomeUsuario;
    this.dataEmprestimo = new Date();
  }

  public Livro getLivro() {
    return livro;
  }

  public String getNomeUsuario() {
    return nomeUsuario;
  }

  public Date getDataEmprestimo() {
    return dataEmprestimo;
  }
}
