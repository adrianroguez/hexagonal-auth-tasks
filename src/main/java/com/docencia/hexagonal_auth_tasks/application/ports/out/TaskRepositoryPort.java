package com.docencia.hexagonal_auth_tasks.application.ports.out;

import java.util.List;
import java.util.Optional;

import com.docencia.hexagonal_auth_tasks.domain.model.Task;

/**
 * Puerto de salida para operaciones de persistencia de tareas.
 * Define los metodos que debe implementar cualquier adaptador de repositorio de tareas.
 */
public interface TaskRepositoryPort {
    /**
     * Guarda una tarea en la persistencia.
     *
     * @param task tarea a guardar
     * @return tarea guardada
     */
    Task save(Task task);

    /**
     * Busca una tarea por su identificador.
     *
     * @param id identificador de la tarea
     * @return Optional con la tarea si existe
     */
    Optional<Task> findById(Long id);

    /**
     * Obtiene todas las tareas de un usuario especifico.
     *
     * @param userId identificador del usuario
     * @return lista de tareas del usuario
     */
    List<Task> findAllByUserId(Long userId);

    /**
     * Elimina una tarea por su identificador.
     *
     * @param id identificador de la tarea a eliminar
     */
    void deleteById(Long id);
}
