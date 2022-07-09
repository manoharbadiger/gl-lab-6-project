package com.gl.spring.crupapi.utils;

import com.gl.spring.crupapi.model.Student;
import com.gl.spring.crupapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BootstrapApplicationData implements ApplicationListener<ApplicationReadyEvent> {
    private final StudentRepository studentRepository;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        for(long i=0 ; i < 10; i++){
            Student student = new Student();
            student.setCountry("India");
            student.setId(i);
            student.setStudentName("Manohar");
            student.setDepartment("B.Tech");
            studentRepository.save(student);
        }
    }
}
