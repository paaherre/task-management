package com.example.task_management.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "assignedUser")
    private List<Task> tasks;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}