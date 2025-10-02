package com.proyecto.student_management.domain;
//clase joco
public class Student {

    //atributos de un alumno id, nombre, email, edad, curso
    private int id;
    private String name;
    private String email;
    private int age;
    private String course;

    //constructor


    public Student(int id, String name, String email, int age, String course) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.course = course;
    }
    //getter & setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int edad) {
        this.age = edad;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
