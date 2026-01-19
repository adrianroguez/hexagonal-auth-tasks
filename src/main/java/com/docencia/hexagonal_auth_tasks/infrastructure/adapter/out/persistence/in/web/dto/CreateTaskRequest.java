package com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.in.web.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO para solicitud de creacion de tarea.
 * Contiene los datos necesarios para crear una nueva tarea en el sistema.
 */
public class CreateTaskRequest {

    /** Titulo de la tarea requerido y no en blanco */
    @NotBlank(message = "Title is required")
    private String title;

    /** Descripcion opcional de la tarea */
    private String description;

    /**
     * Constructor por defecto.
     */
    public CreateTaskRequest() {
    }

    /**
     * Constructor con parametros.
     *
     * @param title titulo de la tarea
     * @param description descripcion de la tarea
     */
    public CreateTaskRequest(String title, String description) {
        this.title = title;
        this.description = description;
    }

    /**
     * Obtiene el titulo de la tarea.
     *
     * @return el titulo
     */
    public String getTitle() {
        return title;
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
        return description;
    }

    /**
     * Establece la descripcion de la tarea.
     *
     * @param description descripcion a establecer
     */
    public void setDescription(String description) {
        this.description = description;
    }
}