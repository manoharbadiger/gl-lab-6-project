package com.gl.spring.crupapi.service;

import com.gl.spring.crupapi.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {

    Student saveStudent(Student department);

    List<Student> fetchAllStudents();

    Student updateStudent(Student student,
                             Long studentId);

    void deleteStudentById(Long studentId);
}
