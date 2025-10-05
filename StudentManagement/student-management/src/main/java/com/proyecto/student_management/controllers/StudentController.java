
package com.proyecto.student_management.controllers;

import com.proyecto.student_management.domain.Student;
import com.proyecto.student_management.dto.StudentDTO;
import com.proyecto.student_management.mapper.StudentMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.*;
        import java.util.stream.Collectors;

@RestController
@RequestMapping("/alumnos")
public class StudentController {

    private List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1, "Hugo Reyes", "hugoreyes@email.com", 18, "Ingeniería robótica"),
            new Student(2, "Borja Reyes", "borjareyes@email.com", 19, "Ingeniería mecánica"),
            new Student(3, "Ana Marín", "anamarin@email.com", 25, "Desarrollo de app multiplataforma"),
            new Student(4, "Miriam Ramos", "miriamramos@email.com", 23, "Relaciones Públicas")
    ));

    @GetMapping
    public List<StudentDTO> getStudents() {
        return students.stream().map(StudentMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{email}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable String email) {
        return students.stream()
                .filter(s -> s.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .map(StudentMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentDTO dto) {
        Student s = StudentMapper.toEntity(dto);
        students.add(s);
        return ResponseEntity.status(201).body(StudentMapper.toDto(s));
    }

    @PutMapping
    public ResponseEntity<StudentDTO> updateStudent(@Valid @RequestBody StudentDTO dto) {
        for (Student s : students) {
            if (s.getId() == dto.getId()) {
                s.setName(dto.getName());
                s.setEmail(dto.getEmail());
                s.setAge(dto.getAge());
                s.setCourse(dto.getCourse());
                return ResponseEntity.ok(StudentMapper.toDto(s));
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentDTO> deleteStudent(@PathVariable int id) {
        Optional<Student> found = students.stream().filter(s -> s.getId() == id).findFirst();
        if (found.isPresent()) {
            students.remove(found.get());
            return ResponseEntity.ok(StudentMapper.toDto(found.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
