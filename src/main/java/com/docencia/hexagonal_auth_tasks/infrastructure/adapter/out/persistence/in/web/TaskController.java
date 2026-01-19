package com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.in.web;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docencia.hexagonal_auth_tasks.application.ports.in.TaskServicePort;
import com.docencia.hexagonal_auth_tasks.application.ports.in.UserServicePort;
import com.docencia.hexagonal_auth_tasks.domain.model.Task;
import com.docencia.hexagonal_auth_tasks.domain.model.User;
import com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.in.web.dto.CreateTaskRequest;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

/**
 * Controlador REST para la gestion de tareas.
 * Proporciona endpoints para crear, recuperar y eliminar tareas del usuario autenticado.
 */
@RestController
@RequestMapping("/api/tasks")
@SecurityRequirement(name = "bearerAuth")
public class TaskController {

    /** Puerto del servicio de tareas */
    private final TaskServicePort taskServicePort;
    /** Puerto del servicio de usuarios */
    private final UserServicePort userServicePort;

    /**
     * Constructor del controlador de tareas.
     *
     * @param taskServicePort puerto del servicio de tareas
     * @param userServicePort puerto del servicio de usuarios
     */
    public TaskController(TaskServicePort taskServicePort, UserServicePort userServicePort) {
        this.taskServicePort = taskServicePort;
        this.userServicePort = userServicePort;
    }

    /**
     * Crea una nueva tarea para el usuario autenticado.
     *
     * @param request datos de la tarea a crear
     * @return respuesta con la tarea creada
     */
    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody CreateTaskRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        User user = userServicePort.findByUsername(currentUsername)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Task newTask = new Task(
                null,
                request.getTitle(),
                request.getDescription(),
                LocalDateTime.now(),
                null,
                false,
                null);
        Task createdTask = taskServicePort.createTask(user.getId(), newTask);
        return ResponseEntity.ok(createdTask);
    }

    /**
     * Obtiene todas las tareas del usuario autenticado.
     *
     * @return respuesta con la lista de tareas del usuario
     */
    @GetMapping
    public ResponseEntity<List<Task>> getMyTasks() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        User user = userServicePort.findByUsername(currentUsername)
                .orElseThrow(() -> new RuntimeException("User not found"));
        List<Task> tasks = taskServicePort.getTasksByUserId(user.getId());
        tasks.forEach(task -> task.setUser(null));
        return ResponseEntity.ok(tasks);
    }

    /**
     * Elimina una tarea por su identificador.
     *
     * @param id identificador de la tarea a eliminar
     * @return respuesta sin contenido
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskServicePort.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}