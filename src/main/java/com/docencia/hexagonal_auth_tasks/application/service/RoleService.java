package com.docencia.hexagonal_auth_tasks.application.service;

import org.springframework.stereotype.Service;

import com.docencia.hexagonal_auth_tasks.application.ports.in.RoleServicePort;
import com.docencia.hexagonal_auth_tasks.application.ports.out.RoleRepositoryPort;
import com.docencia.hexagonal_auth_tasks.domain.model.Role;

/**
 * Servicio para la gestion de roles.
 * Implementa la logica de negocio relacionada con la obtencion de roles.
 */
@Service
public class RoleService implements RoleServicePort {
    private final RoleRepositoryPort repositoryPort;

    /**
     * Constructor del servicio de roles.
     *
     * @param repositoryPort puerto del repositorio de roles
     */
    public RoleService(RoleRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    /**
     * Obtiene un rol por su nombre.
     *
     * @param name nombre del rol a buscar
     * @return el rol encontrado o null si no existe
     */
    @Override
    public Role getRoleByName(String name) {
        return repositoryPort.findByName(name).orElse(null);
    }

}
