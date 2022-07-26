package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student createStudent(Student student) { // create
        return studentRepository.save(student);
    }

    public Student getStudent(Long id) { // read
        return studentRepository.findById(id).get();
    } // read

    public Student changeStudent(Student changedStudent) { //update
        return studentRepository.save(changedStudent);
    }


    public void removeStudent(Long id) { // delete
        studentRepository.deleteById(id);
    }

    public Collection<Student> getAll() {
        return studentRepository.findAll();
    }

    public Collection<Student> findByAge(int age) {
        return studentRepository.findAll()
                .stream()
                .filter(student -> student.getAge()==age).collect(Collectors.toList());

    }
}
