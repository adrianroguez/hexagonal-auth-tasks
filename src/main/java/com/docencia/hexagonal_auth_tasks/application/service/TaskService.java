package com.docencia.hexagonal_auth_tasks.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.docencia.hexagonal_auth_tasks.application.ports.in.TaskServicePort;
import com.docencia.hexagonal_auth_tasks.application.ports.out.TaskRepositoryPort;
import com.docencia.hexagonal_auth_tasks.application.ports.out.UserRepositoryPort;
import com.docencia.hexagonal_auth_tasks.domain.model.Task;
import com.docencia.hexagonal_auth_tasks.domain.model.User;

/**
 * Servicio para la gestion de tareas.
 * Implementa la logica de negocio relacionada con las operaciones de tareas.
 */
@Service
public class TaskService implements TaskServicePort {
    private final TaskRepositoryPort taskRepositoryPort;
    private final UserRepositoryPort userRepositoryPort;

    /**
     * Constructor del servicio de tareas.
     *
     * @param taskRepositoryPort puerto del repositorio de tareas
     * @param userRepositoryPort puerto del repositorio de usuarios
     */
    public TaskService(TaskRepositoryPort taskRepositoryPort, UserRepositoryPort userRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
        this.userRepositoryPort = userRepositoryPort;
    }

    /**
     * Crea una nueva tarea para un usuario.
     *
     * @param userId identificador del usuario propietario
     * @param task objeto tarea a crear
     * @return la tarea creada
     */
    @Override
    public Task createTask(Long userId, Task task) {
        User user = userRepositoryPort.findById(userId).orElse(null);
        task.setUser(user);
        return taskRepositoryPort.save(task);
    }

    /**
     * Obtiene todas las tareas de un usuario.
     *
     * @param userId identificador del usuario
     * @return lista de tareas del usuario
     */
    @Override
    public List<Task> getTasksByUserId(Long userId) {
        return taskRepositoryPort.findAllByUserId(userId);
    }

    /**
     * Elimina una tarea por su identificador.
     *
     * @param taskId identificador de la tarea a eliminar
     */
    @Override
    public void deleteTask(Long taskId) {
        taskRepositoryPort.deleteById(taskId);
    }

}
