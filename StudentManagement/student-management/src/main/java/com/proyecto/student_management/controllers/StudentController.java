package com.proyecto.student_management.controllers;

import com.proyecto.student_management.domain.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping ("/alumnos")
public class StudentController {

    //lista de recursos
    private List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1, "Hugo Reyes", "hugoreyes@email.com", 18, "Ingeniería robótica"),
            new Student(2, "Borja Reyes", "borjareyes@email.com", 19, "Ingeniería mecánica"),
            new Student(3, "Ana Marín", "anamarin@email.com", 25, "Desarrollo de app multiplataforma"),
            new Student(4, "Miriam Ramos", "miriamramos@email.com", 23, "Relaciones Públicas")
    ));

    //Mostrar todos los alumnos
    @GetMapping
    public List<Student> getStudents() {

        return students;

    }

    //Consultar alumno por email
    @GetMapping("/{email}")
    public Student getStudent(@PathVariable String email) {
        for (Student s : students) {
            if (s.getEmail().equalsIgnoreCase(email)) {
                return s;
            }
        }
        return null;
    }
    //Crear un alumno nuevo
    @PostMapping
    public Student postStudent(@RequestBody Student student){
        students.add(student);

        return student;

    }
    //Modificación total de un alumno
    @PutMapping
    public Student putStudent(@RequestBody Student student){
        for(Student s : students){
            if(s.getId() == student.getId()){
               s.setName(student.getName());
               s.setEmail(student.getEmail());
               s.setAge(student.getAge());
               s.setCourse(student.getCourse());

               return s;
            }
        }
        return null;

    }

    //Modificar algún dato
    @PatchMapping
    public Student patchStudent(@RequestBody Student student){
        for (Student s : students){
            if(s.getId() == student.getId()){

                if(student.getName() != null){
                    s.setName(student.getName());

                }
                if(student.getEmail() != null){
                    s.setEmail(student.getEmail());

                }
                if(student.getAge() != 0){
                    s.setAge(student.getAge());

                }
                if(student.getCourse() != null){
                    s.setCourse(student.getCourse());

                }
                return s;
            }
        }
        return  null;


    }

    //Eliminar un alumno
    @DeleteMapping("/{id}")
    public Student deleteStudent(@PathVariable int id){
        for (Student s : students){
            if(s.getId() == id){
                students.remove(s);

                return s;
            }
        }

        return null;


    }
}
