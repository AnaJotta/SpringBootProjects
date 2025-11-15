package com.anajotta.Notitas.repository;

import com.anajotta.Notitas.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
  // JpaRepository ya tiene métodos CRUD por defecto: save, findAll, findById, deleteById
}
