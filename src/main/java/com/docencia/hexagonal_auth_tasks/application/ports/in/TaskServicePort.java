package com.docencia.hexagonal_auth_tasks.application.ports.in;

import java.util.List;

import com.docencia.hexagonal_auth_tasks.domain.model.Task;

/**
 * Puerto de entrada para el servicio de tareas.
 * Define los metodos necesarios para gestionar tareas en el sistema.
 */
public interface TaskServicePort {
    /**
     * Crea una nueva tarea asociada a un usuario.
     *
     * @param userId identificador del usuario propietario de la tarea
     * @param task objeto con los datos de la tarea a crear
     * @return la tarea creada
     */
    Task createTask(Long userId, Task task);

    /**
     * Obtiene todas las tareas de un usuario especifico.
     *
     * @param userId identificador del usuario
     * @return lista de tareas del usuario
     */
    List<Task> getTasksByUserId(Long userId);

    /**
     * Elimina una tarea por su identificador.
     *
     * @param taskId identificador de la tarea a eliminar
     */
    void deleteTask(Long taskId);
}
