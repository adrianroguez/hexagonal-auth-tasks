package com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.docencia.hexagonal_auth_tasks.application.ports.out.UserRepositoryPort;
import com.docencia.hexagonal_auth_tasks.domain.model.User;
import com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.entity.UserEntity;
import com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.mapper.UserMapper;
import com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.repository.JpaUserRepository;

/**
 * Adaptador que implementa el puerto de repositorio de usuarios.
 * Proporciona la persistencia y recuperacion de usuarios usando JPA y mapeo de entidades.
 */
@Component
public class UserRepositoryAdapter implements UserRepositoryPort {
    /** Repositorio JPA para usuarios */
    private final JpaUserRepository repository;
    /** Mapeador de entidad a dominio y viceversa */
    private final UserMapper mapper;

    /**
     * Constructor del adaptador de repositorio de usuarios.
     *
     * @param repository repositorio JPA
     * @param mapper mapeador de usuario
     */
    public UserRepositoryAdapter(JpaUserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Guarda un usuario en la base de datos.
     *
     * @param user usuario del dominio a guardar
     * @return usuario del dominio guardado
     */
    @Override
    public User save(User user) {
        UserEntity entity = mapper.toEntity(user);
        UserEntity savedEntity = repository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param username nombre de usuario
     * @return Optional con el usuario si existe
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username).map(mapper::toDomain);
    }

    /**
     * Verifica si existe un usuario con el nombre proporcionado.
     *
     * @param username nombre de usuario a verificar
     * @return true si el usuario existe
     */
    @Override
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    /**
     * Busca un usuario por su identificador.
     *
     * @param id identificador del usuario
     * @return Optional con el usuario si existe
     */
    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

}
