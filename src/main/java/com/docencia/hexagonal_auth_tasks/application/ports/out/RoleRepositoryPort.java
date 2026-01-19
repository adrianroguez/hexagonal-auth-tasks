package com.docencia.hexagonal_auth_tasks.application.ports.out;

import java.util.Optional;

import com.docencia.hexagonal_auth_tasks.domain.model.Role;

/**
 * Puerto de salida para operaciones de persistencia de roles.
 * Define los metodos que debe implementar cualquier adaptador de repositorio de roles.
 */
public interface RoleRepositoryPort {
    /**
     * Busca un rol por su nombre.
     *
     * @param name nombre del rol
     * @return Optional con el rol si existe
     */
    Optional<Role> findByName(String name);
}
