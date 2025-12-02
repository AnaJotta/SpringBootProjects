package com.anajotta.Notitas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "notas")
public class Nota {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String titulo;

  // 1. ¿La variable se llama 'contenido'?
  private String contenido;

  private boolean completada;

  public Nota() {
  }

  // 2. ¡IMPORTANTE! Revisa este constructor.
  // ¿Estás asignando 'this.contenido = contenido'?
  // Si pone 'this.descripcion = contenido' o algo raro, ahí está el fallo.
  public Nota(String titulo, String contenido, boolean completada) {
    this.titulo = titulo;
    this.contenido = contenido; // <--- ESTA LÍNEA ES CRUCIAL
    this.completada = completada;
  }

  // 3. Revisa los Getters y Setters
  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getContenido() {
    return contenido;
  }

  public void setContenido(String contenido) { // <--- Revisa este setter
    this.contenido = contenido;
  }

  public boolean isCompletada() {
    return completada;
  }

  public void setCompletada(boolean completada) {
    this.completada = completada;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}