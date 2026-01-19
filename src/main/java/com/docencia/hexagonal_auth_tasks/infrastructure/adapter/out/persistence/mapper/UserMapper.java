package com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.docencia.hexagonal_auth_tasks.domain.model.User;
import com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.entity.UserEntity;

/**
 * Mapeador para convertir entre la entidad UserEntity y el modelo de dominio User.
 * Utiliza MapStruct para generar automaticamente el codigo de mapeo.
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    /**
     * Convierte una entidad UserEntity al modelo de dominio User.
     * Ignora el mapeo de tareas para evitar cargos innecesarios.
     *
     * @param entity entidad de base de datos
     * @return objeto de dominio
     */
    @Mapping(target = "tasks", ignore = true)
    User toDomain(UserEntity entity);

    /**
     * Convierte un modelo de dominio User a entidad UserEntity.
     *
     * @param user objeto de dominio
     * @return entidad de base de datos
     */
    UserEntity toEntity(User user);
}