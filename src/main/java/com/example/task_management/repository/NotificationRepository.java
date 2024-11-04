package com.example.task_management.repository;

import com.example.task_management.model.Notification;
import com.example.task_management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository <Notification, Long> {
    List<Notification> findByUser(User user);
}
