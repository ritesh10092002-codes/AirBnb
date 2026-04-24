package com.example.airbnbApp.entity;

import com.example.airbnbApp.entity.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "app_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String email;


    @Column(nullable = false)
    private String password;

    private String name;

    //This annotation create separate table in DB by JPA automatically, used for string, integer, embedded object
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.ORDINAL)
    private Set<Role> roles;
}
