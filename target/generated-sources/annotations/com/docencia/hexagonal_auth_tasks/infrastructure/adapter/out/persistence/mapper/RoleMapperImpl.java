package com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.mapper;

import com.docencia.hexagonal_auth_tasks.domain.model.Role;
import com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.entity.RoleEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-19T02:22:06+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260101-2150, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role toDomain(RoleEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( entity.getId() );
        role.setName( entity.getName() );

        return role;
    }

    @Override
    public RoleEntity toEntity(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setId( role.getId() );
        roleEntity.setName( role.getName() );

        return roleEntity;
    }
}
