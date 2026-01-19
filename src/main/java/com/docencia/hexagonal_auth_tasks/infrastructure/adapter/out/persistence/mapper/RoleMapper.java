package com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;

import com.docencia.hexagonal_auth_tasks.domain.model.Role;
import com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.entity.RoleEntity;

/**
 * Mapeador para convertir entre la entidad RoleEntity y el modelo de dominio Role.
 * Utiliza MapStruct para generar automaticamente el codigo de mapeo.
 */
@Mapper(componentModel = "spring")
public interface RoleMapper {
    /**
     * Convierte una entidad RoleEntity al modelo de dominio Role.
     *
     * @param entity entidad de base de datos
     * @return objeto de dominio
     */
    Role toDomain(RoleEntity entity);

    /**
     * Convierte un modelo de dominio Role a entidad RoleEntity.
     *
     * @param role objeto de dominio
     * @return entidad de base de datos
     */
    RoleEntity toEntity(Role role);
}
