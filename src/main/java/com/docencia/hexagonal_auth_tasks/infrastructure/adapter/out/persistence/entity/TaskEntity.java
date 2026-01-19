package com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entidad JPA para persistencia de tareas en la base de datos.
 * Mapea la tabla 'tasks' y define la relacion con el usuario propietario.
 */
@Entity
@Table(name = "tasks")
public class TaskEntity {
    /** Identificador unico de la entidad tarea */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /** Titulo de la tarea */
    private String title;
    /** Descripcion detallada de la tarea */
    private String description;
    /** Fecha y hora de inicio de la tarea */
    private LocalDateTime startDate;
    /** Fecha y hora de finalizacion de la tarea */
    private LocalDateTime endDate;
    /** Indicador de si la tarea ha sido completada */
    private boolean completed;
    /** Referencia al usuario propietario (lazy fetch) */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    /**
     * Constructor por defecto.
     */
    public TaskEntity() {
    }

    /**
     * Constructor con identificador.
     *
     * @param id identificador de la tarea
     */
    public TaskEntity(Long id) {
        this.id = id;
    }

    /**
     * Constructor con todos los parametros.
     *
     * @param id identificador de la tarea
     * @param title titulo de la tarea
     * @param description descripcion de la tarea
     * @param startDate fecha de inicio
     * @param endDate fecha de finalizacion
     * @param completed estado de completacion
     * @param user usuario propietario
     */
    public TaskEntity(Long id, String title, String description, LocalDateTime startDate, LocalDateTime endDate,
            boolean completed, UserEntity user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.completed = completed;
        this.user = user;
    }

    /**
     * Obtiene el identificador de la tarea.
     *
     * @return el id de la tarea
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Establece el identificador de la tarea.
     *
     * @param id identificador a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el titulo de la tarea.
     *
     * @return el titulo
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Establece el titulo de la tarea.
     *
     * @param title titulo a establecer
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Obtiene la descripcion de la tarea.
     *
     * @return la descripcion
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Establece la descripcion de la tarea.
     *
     * @param description descripcion a establecer
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtiene la fecha de inicio de la tarea.
     *
     * @return la fecha de inicio
     */
    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    /**
     * Establece la fecha de inicio de la tarea.
     *
     * @param startDate fecha de inicio a establecer
     */
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    /**
     * Obtiene la fecha de finalizacion de la tarea.
     *
     * @return la fecha de finalizacion
     */
    public LocalDateTime getEndDate() {
        return this.endDate;
    }

    /**
     * Establece la fecha de finalizacion de la tarea.
     *
     * @param endDate fecha de finalizacion a establecer
     */
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    /**
     * Verifica si la tarea ha sido completada.
     *
     * @return true si la tarea esta completada
     */
    public boolean isCompleted() {
        return this.completed;
    }

    /**
     * Obtiene el estado de completacion de la tarea.
     *
     * @return true si la tarea esta completada
     */
    public boolean getCompleted() {
        return this.completed;
    }

    /**
     * Establece el estado de completacion de la tarea.
     *
     * @param completed estado de completacion a establecer
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Obtiene el usuario propietario de la tarea.
     *
     * @return el usuario
     */
    public UserEntity getUser() {
        return this.user;
    }

    /**
     * Establece el usuario propietario de la tarea.
     *
     * @param user usuario a establecer
     */
    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TaskEntity)) {
            return false;
        }
        TaskEntity taskEntity = (TaskEntity) o;
        return Objects.equals(id, taskEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", title='" + getTitle() + "'" +
                ", description='" + getDescription() + "'" +
                ", startDate='" + getStartDate() + "'" +
                ", endDate='" + getEndDate() + "'" +
                ", completed='" + isCompleted() + "'" +
                ", user='" + getUser() + "'" +
                "}";
    }

}
