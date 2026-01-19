package com.docencia.hexagonal_auth_tasks.application.ports.out;

import java.util.Optional;

import com.docencia.hexagonal_auth_tasks.domain.model.User;

/**
 * Puerto de salida para operaciones de persistencia de usuarios.
 * Define los metodos que debe implementar cualquier adaptador de repositorio de usuarios.
 */
public interface UserRepositoryPort {
    /**
     * Guarda un usuario en la persistencia.
     *
     * @param user usuario a guardar
     * @return usuario guardado
     */
    User save(User user);

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param username nombre de usuario
     * @return Optional con el usuario si existe
     */
    Optional<User> findByUsername(String username);

    /**
     * Verifica si existe un usuario con el nombre proporcionado.
     *
     * @param username nombre de usuario a verificar
     * @return true si el usuario existe
     */
    boolean existsByUsername(String username);

    /**
     * Busca un usuario por su identificador.
     *
     * @param id identificador del usuario
     * @return Optional con el usuario si existe
     */
    Optional<User> findById(Long id);
}
