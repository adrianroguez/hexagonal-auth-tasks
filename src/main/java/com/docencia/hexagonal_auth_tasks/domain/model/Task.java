package com.docencia.hexagonal_auth_tasks.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Modelo de dominio para las tareas del sistema.
 * Representa una tarea individual asignada a un usuario con fecha de inicio y finalizacion.
 */
public class Task {
    /** Identificador unico de la tarea */
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
    /** Usuario propietario de la tarea */
    @JsonIgnoreProperties("tasks")
    private User user;

    /**
     * Constructor por defecto.
     */
    public Task() {
    }

    /**
     * Constructor con identificador.
     *
     * @param id identificador de la tarea
     */
    public Task(Long id) {
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
     * @param completed estado de finalizacion
     * @param user usuario propietario
     */
    public Task(Long id, String title, String description, LocalDateTime startDate, LocalDateTime endDate,
            boolean completed, User user) {
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
    public User getUser() {
        return this.user;
    }

    /**
     * Establece el usuario propietario de la tarea.
     *
     * @param user usuario a establecer
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Task)) {
            return false;
        }
        Task task = (Task) o;
        return Objects.equals(id, task.id);
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
