package ru.kata.spring.boot_security.demo.model;

import lombok.Data;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;

    public Role() { }

    public Role(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }

}
