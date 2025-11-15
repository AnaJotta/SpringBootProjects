package com.anajotta.Notitas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "notas")
public class Nota {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String titulo;
  private String descripcion;
  private boolean completada;

  // Constructor vacío
  public Nota() {}

  // Constructor completo
  public Nota(String titulo, String descripcion, boolean completada) {
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.completada = completada;
  }

  // Getters y setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getTitulo() { return titulo; }
  public void setTitulo(String titulo) { this.titulo = titulo; }

  public String getDescripcion() { return descripcion; }
  public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

  public boolean isCompletada() { return completada; }
  public void setCompletada(boolean completada) { this.completada = completada; }
}