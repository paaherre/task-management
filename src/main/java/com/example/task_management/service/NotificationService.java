package com.example.task_management.service;

import com.example.task_management.model.Notification;
import com.example.task_management.model.NotificationType;
import com.example.task_management.model.Task;
import com.example.task_management.model.User;
import com.example.task_management.repository.NotificationRepository;
import com.example.task_management.repository.TaskRepository;
import com.example.task_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public void createNotification(Long taskId, NotificationType type, String message) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        Notification notification = new Notification();
        notification.setTask(task);
        notification.setUser(task.getAdminUser()); // Notificar al administrador
        notification.setType(type);
        notification.setMessage(message);
        notification.setTimestamp(LocalDateTime.now());
        notificationRepository.save(notification);
    }

    public List<Notification> getNotificationsForUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return notificationRepository.findByUser(user);
    }
}
