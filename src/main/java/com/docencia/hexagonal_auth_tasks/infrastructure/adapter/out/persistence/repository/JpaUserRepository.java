package com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.entity.UserEntity;

/**
 * Repositorio JPA para operaciones CRUD de la entidad UserEntity.
 * Proporciona acceso directo a la base de datos para usuarios.
 */
public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param username nombre de usuario a buscar
     * @return Optional con la entidad usuario si existe
     */
    Optional<UserEntity> findByUsername(String username);

    /**
     * Verifica si existe un usuario con el nombre proporcionado.
     *
     * @param username nombre de usuario a verificar
     * @return true si el usuario existe
     */
    boolean existsByUsername(String username);
}
