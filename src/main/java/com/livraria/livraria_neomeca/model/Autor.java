package com.livraria.livraria_neomeca.model;

import java.util.Date;

import lombok.Data;

@Data
public class Autor {
  private int id;
  private String nome;
  private Date dataNascimento;

  public Autor(int id, String nome, Date dataNascimento) {
    this.id = id;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
  }

  public String getNome() {
    return nome;
  }
}
