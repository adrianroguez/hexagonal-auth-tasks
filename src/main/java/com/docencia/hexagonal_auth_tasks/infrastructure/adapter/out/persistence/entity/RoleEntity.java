package com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad JPA para persistencia de roles en la base de datos.
 * Mapea la tabla 'roles' con identificador unico y nombre de rol.
 */
@Entity
@Table(name = "roles")
public class RoleEntity {
    /** Identificador unico de la entidad rol */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /** Nombre del rol unico y no nulo */
    @Column(unique = true, nullable = false)
    private String name;

    /**
     * Constructor por defecto.
     */
    public RoleEntity() {
    }

    /**
     * Constructor con identificador.
     *
     * @param id identificador del rol
     */
    public RoleEntity(Long id) {
        this.id = id;
    }

    /**
     * Constructor con todos los parametros.
     *
     * @param id identificador del rol
     * @param name nombre del rol
     */
    public RoleEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Obtiene el identificador del rol.
     *
     * @return el id del rol
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Establece el identificador del rol.
     *
     * @param id identificador a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del rol.
     *
     * @return el nombre del rol
     */
    public String getName() {
        return this.name;
    }

    /**
     * Establece el nombre del rol.
     *
     * @param name nombre a establecer
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RoleEntity)) {
            return false;
        }
        RoleEntity roleEntity = (RoleEntity) o;
        return Objects.equals(id, roleEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                "}";
    }

}
