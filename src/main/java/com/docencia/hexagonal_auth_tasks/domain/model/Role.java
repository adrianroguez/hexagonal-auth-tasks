package com.docencia.hexagonal_auth_tasks.domain.model;
import java.util.Objects;

/**
 * Modelo de dominio para los roles de usuario.
 * Representa los diferentes roles disponibles en el sistema.
 */
public class Role {
    /** Identificador unico del rol */
    private Long id;
    /** Nombre del rol */
    private String name;

    /**
     * Constructor por defecto.
     */
    public Role() {
    }

    /**
     * Constructor con parametros.
     *
     * @param id identificador del rol
     * @param name nombre del rol
     */
    public Role(Long id, String name) {
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
        if (!(o instanceof Role)) {
            return false;
        }
        Role role = (Role) o;
        return Objects.equals(id, role.id);
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
