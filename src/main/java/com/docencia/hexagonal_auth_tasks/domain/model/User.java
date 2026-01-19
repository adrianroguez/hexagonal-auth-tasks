package com.docencia.hexagonal_auth_tasks.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Modelo de dominio para los usuarios del sistema.
 * Representa un usuario con sus datos basicos, tareas y roles asignados.
 */
public class User {
    /** Identificador unico del usuario */
    private Long id;
    /** Nombre de usuario unico */
    private String username;
    /** Contrasena del usuario (no se serializa en JSON) */
    @JsonIgnore
    private String password;
    /** Lista de tareas del usuario (no se serializa en JSON) */
    @JsonIgnore
    private List<Task> tasks = new ArrayList<>();
    /** Lista de roles asignados al usuario */
    private List<Role> roles = new ArrayList<>();

    /**
     * Constructor por defecto.
     */
    public User() {
    }

    /**
     * Constructor con identificador.
     *
     * @param id identificador del usuario
     */
    public User(Long id) {
        this.id = id;
    }

    /**
     * Constructor con datos basicos del usuario.
     *
     * @param id identificador del usuario
     * @param username nombre de usuario
     * @param password contrasena del usuario
     */
    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructor con todos los parametros.
     *
     * @param id identificador del usuario
     * @param usename nombre de usuario
     * @param password contrasena del usuario
     * @param tasks lista de tareas
     * @param roles lista de roles
     */
    public User(Long id, String usename, String password, List<Task> tasks, List<Role> roles) {
        this.id = id;
        this.username = usename;
        this.password = password;
        this.tasks = tasks;
        this.roles = roles;
    }

    /**
     * Obtiene el identificador del usuario.
     *
     * @return el id del usuario
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Establece el identificador del usuario.
     *
     * @param id identificador a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de usuario.
     *
     * @return el nombre de usuario
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param usename nombre de usuario a establecer
     */
    public void setUsername(String usename) {
        this.username = usename;
    }

    /**
     * Obtiene la contrasena del usuario.
     *
     * @return la contrasena
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Establece la contrasena del usuario.
     *
     * @param password contrasena a establecer
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene la lista de tareas del usuario.
     *
     * @return lista de tareas
     */
    public List<Task> getTasks() {
        return this.tasks;
    }

    /**
     * Establece la lista de tareas del usuario.
     *
     * @param tasks lista de tareas a establecer
     */
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Obtiene la lista de roles del usuario.
     *
     * @return lista de roles
     */
    public List<Role> getRoles() {
        return this.roles;
    }

    /**
     * Establece la lista de roles del usuario.
     *
     * @param roles lista de roles a establecer
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", usename='" + getUsername() + "'" +
                ", password='" + getPassword() + "'" +
                ", tasks='" + getTasks() + "'" +
                ", roles='" + getRoles() + "'" +
                "}";
    }

}
