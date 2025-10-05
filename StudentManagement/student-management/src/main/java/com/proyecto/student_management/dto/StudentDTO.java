package com.proyecto.student_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO para exponer/recibir datos de Student sin usar directamente la entidad.
 */
public class StudentDTO {

  private int id;

  @NotBlank(message = "El nombre es obligatorio")
  @Size(max = 100)
  private String name;

  @NotBlank(message = "El email es obligatorio")
  @Email(message = "El email no tiene formato válido")
  private String email;

  @NotNull(message = "La edad es obligatoria")
  @Min(value = 1, message = "La edad debe ser positiva")
  private Integer age;

  @NotBlank(message = "El curso es obligatorio")
  private String course;

  public StudentDTO() {}

  public StudentDTO(int id, String name, String email, Integer age, String course) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.age = age;
    this.course = course;
  }

  // Getters y setters
  public int getId() { return id; }
  public void setId(int id) { this.id = id; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
  public Integer getAge() { return age; }
  public void setAge(Integer age) { this.age = age; }
  public String getCourse() { return course; }
  public void setCourse(String course) { this.course = course; }
}
