package com.gl.spring.crupapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "users")
@ToString(exclude = "users")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToMany
    @JoinTable(name="roles_users", joinColumns = {@JoinColumn(name = "fk_role")},
    inverseJoinColumns = {@JoinColumn(name = "fk_user")})
    private Set<User> user;

    public Set<User> getUser() {
        if( this.user == null) {
        this.user = new HashSet<>();
        }
        return user;
    }
}
