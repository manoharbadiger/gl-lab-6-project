package com.gl.spring.crupapi.service;

import com.gl.spring.crupapi.model.Student;
import com.gl.spring.crupapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImplement implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public List<Student> fetchAllStudents() {
        return (List<Student>)
                studentRepository.findAll();
    }

    @Transactional
    public Student updateStudent(Student student, Long studentId) {
        Student studentDb
                = studentRepository.findById(studentId)
                .get();

        if (Objects.nonNull(student.getStudentName())
                && !"".equalsIgnoreCase(
                student.getStudentName())) {
            studentDb.setStudentName(
                    student.getStudentName());
        }

        if (Objects.nonNull(
                student.getDepartment())
                && !"".equalsIgnoreCase(
                student.getDepartment())) {
            studentDb.setDepartment(
                    student.getDepartment());
        }

        if (Objects.nonNull(student.getCountry())
                && !"".equalsIgnoreCase(
                student.getCountry())) {
            studentDb.setCountry(
                    student.getCountry());
        }

        return studentRepository.save(studentDb);

    }

    @Transactional
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public Student getStudent(long id){
        return studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("There is no student information"));
    }


}
