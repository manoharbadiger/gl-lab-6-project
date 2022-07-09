package com.gl.spring.crupapi.repository;

import com.gl.spring.crupapi.model.Role;
import com.gl.spring.crupapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
