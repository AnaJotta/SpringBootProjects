package com.anajotta.Notitas.dto;

public class notaRequestDTO {

  private String titulo;
  private String contenido;

  public notaRequestDTO() {}

  public notaRequestDTO(String titulo, String contenido) {
    this.titulo = titulo;
    this.contenido = contenido;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getContenido() {
    return contenido;
  }

  public void setContenido(String contenido) {
    this.contenido = contenido;
  }
}
