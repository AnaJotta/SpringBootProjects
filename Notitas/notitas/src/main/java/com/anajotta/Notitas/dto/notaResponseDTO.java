package com.anajotta.Notitas.dto;

public class notaResponseDTO {

  private Long id;
  private String titulo;
  private String descripcion;
  private boolean completada;

  public notaResponseDTO() {}

  public notaResponseDTO(Long id, String titulo, String descripcion, boolean completada) {
    this.id = id;
    this.titulo = titulo;
    this.descripcion = descripcion;
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

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public boolean isCompletada() {
    return completada;
  }

  public void setCompletada(boolean completada) {
    this.completada = completada;
  }
}
