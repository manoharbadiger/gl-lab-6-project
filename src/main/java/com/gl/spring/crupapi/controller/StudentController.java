package com.gl.spring.crupapi.controller;

import com.gl.spring.crupapi.model.Student;
import com.gl.spring.crupapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "welcome";
    }

    @PostMapping()
    public Student saveDepartment(@RequestBody Student student) {

        return studentService.saveStudent(student);
    }

    @GetMapping()

    public List<Student> fetchDepartmentList() {
        return studentService.fetchAllStudents();
    }

    @PutMapping("/{id}")

    public Student updateDepartment(@RequestBody Student student, @PathVariable("id") Long studentId) {
        return studentService.updateStudent(student, studentId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CONTINUE)
    public void deleteDepartmentById(@PathVariable("id") Long studentId) {
        studentService.deleteStudentById(studentId);
    }
}
