package com.anajotta.Notitas;

import com.anajotta.Notitas.dto.notaRequestDTO; // Asegúrate de importar tus DTOs
import com.anajotta.Notitas.service.NotaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Importante: ¡Controller, no RestController!
public class WebNotaController {

  private final NotaService notaService;

  public WebNotaController(NotaService notaService) {
    this.notaService = notaService;
  }

  // 1. MOSTRAR LA PÁGINA (GET /)
  @GetMapping("/")
  public String verPaginaInicio(Model model) {
    // Pedimos las notas a la base de datos
    var listaNotas = notaService.listarNotas();

    // Las metemos en la "mochila" (Model) para llevarlas al HTML
    model.addAttribute("notas", listaNotas);

    // También enviamos un objeto vacío para el formulario de crear
    // (Esto es necesario para que Thymeleaf sepa dónde guardar los datos nuevos)
    // Asumo que tu DTO tiene un constructor vacío o por defecto.
    // Para este ejemplo simple, usaremos parámetros directos en el POST.

    return "index"; // Nombre del archivo HTML
  }

  // 2. GUARDAR UNA NOTA NUEVA (POST /guardar)
  @PostMapping("/guardar")
  public String guardarNota(@RequestParam String titulo, @RequestParam String contenido) {
    // Creamos el DTO con los datos que vienen del formulario HTML
    notaRequestDTO nuevaNota = new notaRequestDTO(titulo, contenido);

    // Llamamos al servicio para que la guarde en MySQL
    notaService.crearNota(nuevaNota);

    // Al terminar, "recargamos" la página principal
    return "redirect:/";
  }

  // 3. ELIMINAR UNA NOTA (GET /eliminar)
  @GetMapping("/eliminar")
  public String eliminarNota(@RequestParam Long id) {
    notaService.eliminarNota(id);
    return "redirect:/";
  }
}
/*
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
public class WebController {

  // Inyección del servicio que contiene la lógica de negocio
  private final NotaService notaService;

  // Constructor: Spring inyecta automáticamente el servicio cuando crea el controlador
  public WebController(NotaService notaService) {
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
  public void eliminarNota(@PathVariable Long id){
    // Llama al servicio que elimina la nota indicada
    notaService.eliminarNota(id);
  }
}
*/