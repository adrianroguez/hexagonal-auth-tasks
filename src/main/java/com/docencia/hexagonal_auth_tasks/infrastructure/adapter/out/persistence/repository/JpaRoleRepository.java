package com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.entity.RoleEntity;

/**
 * Repositorio JPA para operaciones CRUD de la entidad RoleEntity.
 * Proporciona acceso directo a la base de datos para roles.
 */
public interface JpaRoleRepository extends JpaRepository<RoleEntity, Long> {
    /**
     * Busca un rol por su nombre.
     *
     * @param name nombre del rol a buscar
     * @return Optional con la entidad rol si existe
     */
    Optional<RoleEntity> findByName(String name);
}
