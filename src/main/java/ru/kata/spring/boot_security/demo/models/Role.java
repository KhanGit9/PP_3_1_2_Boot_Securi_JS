package ru.kata.spring.boot_security.demo.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role")
    @ColumnDefault("ROLE_USER")
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name.replaceAll("ROLE_", "");
    }
}
