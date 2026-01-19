package com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docencia.hexagonal_auth_tasks.application.ports.in.UserServicePort;
import com.docencia.hexagonal_auth_tasks.domain.model.User;
import com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.in.web.dto.AuthResponse;
import com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.in.web.dto.LoginRequest;
import com.docencia.hexagonal_auth_tasks.infrastructure.adapter.out.persistence.in.web.dto.RegisterRequest;
import com.docencia.hexagonal_auth_tasks.infrastructure.security.JwtService;

import jakarta.validation.Valid;

/**
 * Controlador REST para la autenticacion de usuarios.
 * Proporciona endpoints para registro e inicio de sesion con tokens JWT.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    /** Administrador de autenticacion */
    private final AuthenticationManager authenticationManager;
    /** Puerto del servicio de usuarios */
    private final UserServicePort userServicePort;
    /** Servicio para generacion y validacion de tokens JWT */
    private final JwtService jwtService;
    /** Servicio para cargar detalles del usuario */
    private final UserDetailsService userDetailsService;

    /**
     * Constructor del controlador de autenticacion.
     *
     * @param authenticationManager administrador de autenticacion
     * @param userServicePort puerto del servicio de usuarios
     * @param jwtService servicio JWT
     * @param userDetailsService servicio de detalles de usuario
     */
    public AuthController(AuthenticationManager authenticationManager,
            UserServicePort userServicePort,
            JwtService jwtService,
            UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userServicePort = userServicePort;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param request datos de registro del usuario
     * @return respuesta con el token JWT generado
     */
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        User newUser = new User(null, request.getUsername(), request.getPassword());
        userServicePort.register(newUser);
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(token));
    }

    /**
     * Inicia sesion con credenciales de usuario.
     *
     * @param request credenciales de inicio de sesion
     * @return respuesta con el token JWT generado
     */
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtService.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
