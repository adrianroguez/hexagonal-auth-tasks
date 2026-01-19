package com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.docencia.hexagonal_auth_tasks.application.ports.out.TaskRepositoryPort;
import com.docencia.hexagonal_auth_tasks.domain.model.Task;
import com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.entity.TaskEntity;
import com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.mapper.TaskMapper;
import com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.repository.JpaTaskRepository;

/**
 * Adaptador que implementa el puerto de repositorio de tareas.
 * Proporciona persistencia y recuperacion de tareas usando JPA y mapeo de entidades.
 */
@Component
public class TaskRepositoryAdapter implements TaskRepositoryPort {
    /** Repositorio JPA para tareas */
    private final JpaTaskRepository repository;
    /** Mapeador de entidad de tarea a dominio y viceversa */
    private final TaskMapper taskMapper;

    /**
     * Constructor del adaptador de repositorio de tareas.
     *
     * @param repository repositorio JPA
     * @param taskMapper mapeador de tarea
     */
    public TaskRepositoryAdapter(JpaTaskRepository repository, TaskMapper taskMapper) {
        this.repository = repository;
        this.taskMapper = taskMapper;
    }

    /**
     * Guarda una tarea en la base de datos.
     *
     * @param task tarea del dominio a guardar
     * @return tarea del dominio guardada
     */
    @Override
    public Task save(Task task) {
        TaskEntity entity = taskMapper.toEntity(task);
        TaskEntity savedEntity = repository.save(entity);
        return taskMapper.toDomain(savedEntity);
    }

    /**
     * Busca una tarea por su identificador.
     *
     * @param id identificador de la tarea
     * @return Optional con la tarea si existe
     */
    @Override
    public Optional<Task> findById(Long id) {
        return repository.findById(id).map(taskMapper::toDomain);
    }

    /**
     * Obtiene todas las tareas de un usuario especifico.
     * Mapea manualmente las entidades a objetos de dominio sin relacion de usuario.
     *
     * @param userId identificador del usuario
     * @return lista de tareas del usuario
     */
    @Override
    @Transactional(readOnly = true)
    public List<Task> findAllByUserId(Long userId) {
        List<TaskEntity> entities = repository.findAllByUserId(userId);
        return entities.stream().map(entity -> {
            Task task = new Task();
            task.setId(entity.getId());
            task.setTitle(entity.getTitle());
            task.setDescription(entity.getDescription());
            task.setStartDate(entity.getStartDate());
            task.setEndDate(entity.getEndDate());
            task.setCompleted(entity.isCompleted());
            return task;
        }).collect(Collectors.toList());
    }

    /**
     * Elimina una tarea por su identificador.
     *
     * @param id identificador de la tarea a eliminar
     */
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
