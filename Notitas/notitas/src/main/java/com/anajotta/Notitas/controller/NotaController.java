package com.anajotta.Notitas.controller;

import com.anajotta.Notitas.dto.notaResponseDTO;
import com.anajotta.Notitas.dto.notaRequestDTO;
import com.anajotta.Notitas.model.Nota;
import com.anajotta.Notitas.service.NotaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Indica que esta clase es un controlador REST (maneja peticiones HTTP y devuelve JSON)
@RestController
// Define la ruta base para todos los endpoints de este controlador
@RequestMapping("/api/notas")
public class NotaController {

  // Inyección del servicio que contiene la lógica de negocio
  private final NotaService notaService;

  // Constructor: Spring inyecta automáticamente el servicio cuando crea el controlador
  public NotaController(NotaService notaService) {
    this.notaService = notaService;
  }

  // ------------------ ENDPOINTS ------------------

  // Crea una nueva nota (POST /api/notas)
  @PostMapping
  public notaResponseDTO crearNota(@RequestBody notaRequestDTO dto) {
    // Llama al servicio para crear la nota con los datos recibidos en el cuerpo de la petición
    return notaService.crearNota(dto);
  }

  // Nuevo endpoint para crear múltiples notas
  @PostMapping("/batch")
  public List<Nota> crearNotas(@RequestBody List<Nota> notas) {
    return notaService.saveAll(notas);
  }

  // Lista todas las notas (GET /api/notas)
  @GetMapping
  public List<notaResponseDTO> listarNotas() {
    // Devuelve una lista de todas las notas existentes
    return notaService.listarNotas();
  }

  // Obtiene una nota por su ID (GET /api/notas/{id})
  @GetMapping("/{id}")
  public notaResponseDTO obtenerNota(@PathVariable Long id) {
    // Llama al servicio para buscar la nota correspondiente al ID recibido en la URL
    return notaService.obtenerNotaPorId(id);
  }

  // Marca una nota como completada (PUT /api/notas/{id}/completar)
  @PutMapping("/{id}/completar")
  public notaResponseDTO completarNota(@PathVariable Long id) {
    // Llama al servicio que cambia el estado de la nota a "completada"
    return notaService.completarNota(id);
  }

  // Elimina una nota por su ID (DELETE /api/notas/{id})
  @DeleteMapping("/{id}")
  public void eliminarNota(@PathVariable Long id) {
    // Llama al servicio que elimina la nota indicada
    notaService.eliminarNota(id);
  }
}
