package com.proyecto.student_management.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.student_management.dto.StudentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class StudentControllerTest {
  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper mapper;

  @Test
  void getAllStudents_ReturnsList() throws Exception {
    mvc.perform((org.springframework.test.web.servlet.RequestBuilder) get("/alumnos"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].name").exists());
  }

  @Test
  void createStudent_ReturnsCreated() throws Exception {
    StudentDTO dto = new StudentDTO(5, "Nuevo Alumno", "nuevo@email.com", 20, "Matemáticas");

    mvc.perform(post("/alumnos")
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentType(mapper.writeValueAsString(dto)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.email").value("nuevo@email.com"));
  }
}
