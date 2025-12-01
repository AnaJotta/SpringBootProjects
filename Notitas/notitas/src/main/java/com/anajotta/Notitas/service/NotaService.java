package com.anajotta.Notitas.service;

import com.anajotta.Notitas.dto.notaRequestDTO;
import com.anajotta.Notitas.dto.notaResponseDTO;
import com.anajotta.Notitas.model.Nota;
import com.anajotta.Notitas.repository.NotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*Explicación breve de la lógica de negocio

NotaService es la capa que interactúa con
la base de datos a través de NotaRepository.
Recibe DTOs de entrada (NotaRequestDTO)
y devuelve DTOs de salida (NotaResponseDTO).

Aquí aplicamos la lógica de negocio mínima:
Crear la nota como no completada por defecto.
Marcar nota como completada.
Manejar errores si la nota no existe.

Esto mantiene tu controller limpio,
porque el controller solo se encarga de recibir peticiones
y devolver respuestas, mientras que el servicio decide
cómo se manipulan los datos.*/

@Service
public class NotaService {

  private final NotaRepository notaRepository;


  public NotaService(NotaRepository notaRepository) {
    this.notaRepository = notaRepository;
  }

  // Crear una nota
  public notaResponseDTO crearNota(notaRequestDTO dto){
    Nota nota = new Nota(dto.getTitulo(), dto.getContenido(), false);
    Nota guardada = notaRepository.save(nota);
    return new notaResponseDTO(
            guardada.getId(),
            guardada.getTitulo(),
            guardada.getContenido(),
            guardada.isCompletada()
    );

  }
  // Nuevo método para guardar múltiples notas
  public List<Nota> saveAll(List<Nota> notas) {
    return notaRepository.saveAll(notas);
  }

  // Listar todas las notas
  public List<notaResponseDTO> listarNotas() {
    return notaRepository.findAll().stream()
            .map(n -> new notaResponseDTO(n.getId(), n.getTitulo(), n.getContenido(), n.isCompletada()))
            .collect(Collectors.toList());
  }

  // Obtener nota por ID
  public notaResponseDTO obtenerNotaPorId(Long id) {
    Nota n = notaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Nota no encontrada"));
    return new notaResponseDTO(n.getId(), n.getTitulo(), n.getContenido(), n.isCompletada());
  }

  // Marcar nota como completada
  public notaResponseDTO completarNota(Long id) {
    Nota n = notaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Nota no encontrada"));
    n.setCompletada(true);
    Nota actualizada = notaRepository.save(n);
    return new notaResponseDTO(actualizada.getId(), actualizada.getTitulo(), actualizada.getContenido(), actualizada.isCompletada());
  }

  // Eliminar nota
  public void eliminarNota(Long id) {
    if (!notaRepository.existsById(id)) {
      throw new RuntimeException("Nota no encontrada");
    }
    notaRepository.deleteById(id);
  }
}


