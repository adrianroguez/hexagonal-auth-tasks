package com.docencia.hexagonal_auth_tasks.application.ports.in;

import com.docencia.hexagonal_auth_tasks.domain.model.Role;

/**
 * Puerto de entrada para el servicio de roles.
 * Define los metodos necesarios para obtener informacion de roles.
 */
public interface RoleServicePort {
    /**
     * Obtiene un rol por su nombre.
     *
     * @param name nombre del rol a buscar
     * @return el rol encontrado
     */
    Role getRoleByName(String name);
}
