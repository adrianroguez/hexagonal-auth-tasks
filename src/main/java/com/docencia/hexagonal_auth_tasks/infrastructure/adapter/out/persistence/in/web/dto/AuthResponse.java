package com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.in.web.dto;

/**
 * DTO para respuesta de autenticacion.
 * Contiene el token JWT generado tras un inicio de sesion o registro exitoso.
 */
public class AuthResponse {
    /** Token JWT para autenticacion en solicitudes posteriores */
    private String token;

    /**
     * Constructor con token JWT.
     *
     * @param token token JWT generado
     */
    public AuthResponse(String token) {
        this.token = token;
    }

    /**
     * Obtiene el token JWT.
     *
     * @return el token JWT
     */
    public String getToken() {
        return token;
    }

    /**
     * Establece el token JWT.
     *
     * @param token token JWT a establecer
     */
    public void setToken(String token) {
        this.token = token;
    }
}
