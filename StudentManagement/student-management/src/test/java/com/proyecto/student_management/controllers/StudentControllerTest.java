package com.proyecto.student_management.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.student_management.dto.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

  @Autowired
  private MockMvc mvc;

  private ObjectMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = new ObjectMapper(); // 👈 se inicializa antes de cada test
  }

  @Test
  void getAllStudents_ReturnsList() throws Exception {
    mvc.perform(get("/alumnos"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].name").exists());
  }

  @Test
  void createStudent_ReturnsCreated() throws Exception {
    StudentDTO dto = new StudentDTO(5, "Nuevo Alumno", "nuevo@email.com", 20, "Matemáticas");

    mvc.perform(post("/alumnos")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(dto)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.email").value("nuevo@email.com"));
  }
}