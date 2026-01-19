package com.docencia.hexagonal_auth_tasks.application.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.docencia.hexagonal_auth_tasks.application.ports.in.RoleServicePort;
import com.docencia.hexagonal_auth_tasks.application.ports.in.UserServicePort;
import com.docencia.hexagonal_auth_tasks.application.ports.out.UserRepositoryPort;
import com.docencia.hexagonal_auth_tasks.domain.model.Role;
import com.docencia.hexagonal_auth_tasks.domain.model.User;

/**
 * Servicio para la gestion de usuarios.
 * Implementa la logica de negocio relacionada con el registro y busqueda de usuarios.
 */
@Service
public class UserService implements UserServicePort {
    private final UserRepositoryPort userRepositoryPort;
    private final RoleServicePort roleServicePort;
    private final PasswordEncoder passwordEncoder;

    /**
     * Constructor del servicio de usuarios.
     *
     * @param userRepositoryPort puerto del repositorio de usuarios
     * @param roleServicePort puerto del servicio de roles
     * @param passwordEncoder codificador de contrasenas
     */
    public UserService(UserRepositoryPort userRepositoryPort, RoleServicePort roleServicePort,
            PasswordEncoder passwordEncoder) {
        this.userRepositoryPort = userRepositoryPort;
        this.roleServicePort = roleServicePort;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Registra un nuevo usuario en el sistema.
     * Codifica la contrasena y asigna el rol de usuario por defecto.
     *
     * @param user objeto usuario a registrar
     * @return el usuario registrado o null si el nombre de usuario ya existe
     */
    @Override
    public User register(User user) {
        if (userRepositoryPort.existsByUsername(user.getUsername())) {
            return null;
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        Role userRole = roleServicePort.getRoleByName("ROLE_USER");
        user.getRoles().add(userRole);
        return userRepositoryPort.save(user);
    }

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param username nombre de usuario a buscar
     * @return Optional con el usuario si existe
     */
    @Override
    public Optional<User> findByUsername(String username) {
        return userRepositoryPort.findByUsername(username);
    }

}
