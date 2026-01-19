package com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Entidad JPA para persistencia de usuarios en la base de datos.
 * Mapea la tabla 'users' y define las relaciones con roles y tareas.
 */
@Entity
@Table(name = "users")
public class UserEntity {
    /** Identificador unico de la entidad usuario */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /** Nombre de usuario unico y no nulo */
    @Column(unique = true, nullable = false)
    private String username;
    /** Contrasena no nula */
    @Column(nullable = false)
    private String password;
    /** Relacion uno a muchos con tareas (cascade all y borrado de huerfanos) */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TaskEntity> tasks = new HashSet<>();
    /** Relacion muchos a muchos con roles (eager fetch) */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();

    /**
     * Constructor por defecto.
     */
    public UserEntity() {
    }

    /**
     * Constructor con identificador.
     *
     * @param id identificador del usuario
     */
    public UserEntity(Long id) {
        this.id = id;
    }

    /**
     * Constructor con todos los parametros.
     *
     * @param id identificador del usuario
     * @param usename nombre de usuario
     * @param password contrasena
     * @param tasks conjunto de tareas
     * @param roles conjunto de roles
     */
    public UserEntity(Long id, String usename, String password, Set<TaskEntity> tasks, Set<RoleEntity> roles) {
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
     * @param usename nombre a establecer
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
     * Obtiene el conjunto de tareas del usuario.
     *
     * @return conjunto de tareas
     */
    public Set<TaskEntity> getTasks() {
        return this.tasks;
    }

    /**
     * Establece el conjunto de tareas del usuario.
     *
     * @param tasks conjunto de tareas a establecer
     */
    public void setTasks(Set<TaskEntity> tasks) {
        this.tasks = tasks;
    }

    /**
     * Obtiene el conjunto de roles del usuario.
     *
     * @return conjunto de roles
     */
    public Set<RoleEntity> getRoles() {
        return this.roles;
    }

    /**
     * Establece el conjunto de roles del usuario.
     *
     * @param roles conjunto de roles a establecer
     */
    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserEntity)) {
            return false;
        }
        UserEntity userEntity = (UserEntity) o;
        return Objects.equals(id, userEntity.id);
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
