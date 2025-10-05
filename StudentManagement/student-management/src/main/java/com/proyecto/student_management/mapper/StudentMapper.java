package com.proyecto.student_management.mapper;

import com.proyecto.student_management.domain.Student;
import com.proyecto.student_management.dto.StudentDTO;

public class StudentMapper {

  public static StudentDTO toDto(Student s) {
    if (s == null) return null;
    return new StudentDTO(s.getId(), s.getName(), s.getEmail(), s.getAge(), s.getCourse());
  }

  public static Student toEntity(StudentDTO dto) {
    if (dto == null) return null;
    return new Student(dto.getId(), dto.getName(), dto.getEmail(), dto.getAge(), dto.getCourse());
  }
}
