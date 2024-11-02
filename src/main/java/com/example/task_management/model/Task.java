package com.example.task_management.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private LocalDate createdAt;
    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy; // Usuario que crea la tarea

    @ManyToOne
    @JoinColumn(name = "admin_user")
    private User adminUser; // Usuario administrador que supervisa la tarea

    @ManyToOne
    @JoinColumn(name = "assigned_user")
    private User assignedUser;

}
