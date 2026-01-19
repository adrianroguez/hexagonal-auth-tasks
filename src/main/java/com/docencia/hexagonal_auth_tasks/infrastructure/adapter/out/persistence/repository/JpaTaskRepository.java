package com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.entity.TaskEntity;

/**
 * Repositorio JPA para operaciones CRUD de la entidad TaskEntity.
 * Proporciona acceso directo a la base de datos para tareas.
 */
public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {
    /**
     * Busca todas las tareas de un usuario especifico.
     * Utiliza una consulta JPQL personalizada para filtrar por identificador de usuario.
     *
     * @param userId identificador del usuario
     * @return lista de entidades de tarea del usuario
     */
    @Query("SELECT t FROM TaskEntity t WHERE t.user.id = :userId")
    List<TaskEntity> findAllByUserId(Long userId);
}
