package com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.in.web.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO para solicitud de registro de nuevo usuario.
 * Contiene los datos basicos necesarios para crear una nueva cuenta de usuario.
 */
public class RegisterRequest {
    /** Nombre de usuario requerido y no en blanco */
    @NotBlank(message = "Username is required")
    private String username;

    /** Contrasena requerida y no en blanco */
    @NotBlank(message = "Password is required")
    private String password;

    /**
     * Obtiene el nombre de usuario.
     *
     * @return el nombre de usuario
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param username nombre de usuario a establecer
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene la contrasena.
     *
     * @return la contrasena
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contrasena.
     *
     * @param password contrasena a establecer
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
