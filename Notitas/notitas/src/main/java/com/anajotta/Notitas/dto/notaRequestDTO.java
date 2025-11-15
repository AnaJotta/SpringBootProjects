package com.anajotta.Notitas.dto;

public class notaRequestDTO {

  private String titulo;
  private String descripcion;

  public notaRequestDTO() {}

  public notaRequestDTO(String titulo, String descripcion) {
    this.titulo = titulo;
    this.descripcion = descripcion;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
}
