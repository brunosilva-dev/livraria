package com.livraria.livraria_neomeca.model;

import java.util.Date;

import lombok.Data;

@Data
public class Livro {
  private int id;
  private String titulo;
  private Autor autor;
  private boolean disponivel;
  private Date dataCadastro;
  private Date dataAtualizacao;

  public Livro(int id, String titulo, Autor autor) {
    this.id = id;
    this.titulo = titulo;
    this.autor = autor;
    this.disponivel = true; // Inicialmente o livro está disponível
    this.dataCadastro = new Date();
    this.dataAtualizacao = new Date();
  }

  public String getTitulo() {
    return titulo;
  }

  public boolean isDisponivel() {
    return disponivel;
  }

  public void setDisponivel(boolean disponivel) {
    this.disponivel = disponivel;
    this.dataAtualizacao = new Date(); // Atualiza a data ao mudar disponibilidade
  }

  public int getId() {
    return id;
  }

  public Autor getAutor() {
    return autor;
  }
}
