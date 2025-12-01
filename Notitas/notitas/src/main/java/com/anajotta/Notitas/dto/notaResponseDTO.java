package com.anajotta.Notitas.dto;

public class notaResponseDTO {

  private Long id;
  private String titulo;
  private String contenido;
  private boolean completada;

  public notaResponseDTO() {}

  public notaResponseDTO(Long id, String titulo, String contenido, boolean completada) {
    this.id = id;
    this.titulo = titulo;
    this.contenido = contenido;
    this.completada = completada;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public boolean isCompletada() {
    return completada;
  }

  public void setCompletada(boolean completada) {
    this.completada = completada;
  }
}
