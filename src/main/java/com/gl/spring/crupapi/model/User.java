package com.gl.spring.crupapi.model;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
@EqualsAndHashCode(exclude = "roles")
@ToString(exclude = "roles")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String password;
    @ManyToMany(mappedBy = "user")
    private Set<Role> roles;

    public void addRole(Role role){
        if(this.roles == null){
            this.roles = new HashSet<>();
        }
        this.roles.add(role);
        role.getUser().add(this);
    }
}
