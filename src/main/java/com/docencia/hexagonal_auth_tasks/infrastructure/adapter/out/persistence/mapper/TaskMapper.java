package com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;

import com.docencia.hexagonal_auth_tasks.domain.model.Task;
import com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.entity.TaskEntity;

/**
 * Mapeador para convertir entre la entidad TaskEntity y el modelo de dominio Task.
 * Utiliza MapStruct para generar automaticamente el codigo de mapeo.
 */
@Mapper(componentModel = "spring")
public interface TaskMapper {
    /**
     * Convierte una entidad TaskEntity al modelo de dominio Task.
     *
     * @param entity entidad de base de datos
     * @return objeto de dominio
     */
    Task toDomain(TaskEntity entity);

    /**
     * Convierte un modelo de dominio Task a entidad TaskEntity.
     *
     * @param task objeto de dominio
     * @return entidad de base de datos
     */
    TaskEntity toEntity(Task task);
}
