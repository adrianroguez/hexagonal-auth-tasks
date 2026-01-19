package com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.docencia.hexagonal_auth_tasks.application.ports.out.RoleRepositoryPort;
import com.docencia.hexagonal_auth_tasks.domain.model.Role;
import com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.mapper.RoleMapper;
import com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.repository.JpaRoleRepository;

/**
 * Adaptador que implementa el puerto de repositorio de roles.
 * Proporciona persistencia y recuperacion de roles usando JPA y mapeo de entidades.
 */
@Component
public class RoleRepositoryAdapter implements RoleRepositoryPort {
    /** Repositorio JPA para roles */
    private final JpaRoleRepository repository;
    /** Mapeador de entidad de rol a dominio y viceversa */
    private final RoleMapper mapper;

    /**
     * Constructor del adaptador de repositorio de roles.
     *
     * @param repository repositorio JPA
     * @param mapper mapeador de rol
     */
    public RoleRepositoryAdapter(JpaRoleRepository repository, RoleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Busca un rol por su nombre.
     *
     * @param name nombre del rol a buscar
     * @return Optional con el rol si existe
     */
    @Override
    public Optional<Role> findByName(String name) {
        return repository.findByName(name).map(mapper::toDomain);
    }

}
