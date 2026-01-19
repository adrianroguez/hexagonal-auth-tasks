package com.docencia.hexagonal_auth_tasks.application.ports.in;

import java.util.Optional;

import com.docencia.hexagonal_auth_tasks.domain.model.User;

/**
 * Puerto de entrada para el servicio de usuarios.
 * Define los metodos necesarios para la gestion de usuarios.
 */
public interface UserServicePort {
    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param user objeto con los datos del usuario a registrar
     * @return el usuario registrado
     */
    User register(User user);

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param username nombre de usuario a buscar
     * @return Optional con el usuario si existe
     */
    Optional<User> findByUsername(String username);
}
