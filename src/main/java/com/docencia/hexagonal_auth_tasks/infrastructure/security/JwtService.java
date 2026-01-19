package com.docencia.hexagonal_auth_tasks.infrastructure.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

/**
 * Servicio para generacion, validacion y extraccion de informacion de tokens JWT.
 * Maneja toda la logica relacionada con los tokens de autenticacion basados en JWT.
 */
@Service
public class JwtService {
    /** Clave secreta para firmar y verificar tokens (inyectada desde properties) */
    @Value("${app.jwt.secret}")
    private String secretKey;

    /** Duracion de expiracion del token en minutos (inyectada desde properties) */
    @Value("${app.jwt.expiration-minutes}")
    private long jwtExpirationMinutes;

    /**
     * Extrae el nombre de usuario del token JWT.
     *
     * @param token token JWT
     * @return nombre de usuario contenido en el token
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Extrae un reclamo especifico del token JWT.
     *
     * @param token token JWT
     * @param claimsResolver funcion para resolver el reclamo
     * @param <T> tipo del reclamo a extraer
     * @return el reclamo extraido
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Genera un token JWT para detalles de usuario.
     *
     * @param userDetails detalles del usuario
     * @return token JWT generado
     */
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    /**
     * Genera un token JWT con reclamos adicionales personalizados.
     *
     * @param extraClaims reclamos adicionales a incluir en el token
     * @param userDetails detalles del usuario
     * @return token JWT generado
     */
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder()
                .claims(extraClaims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * jwtExpirationMinutes))
                .signWith(getSignInKey(), Jwts.SIG.HS256)
                .compact();
    }

    /**
     * Valida si un token JWT es valido para un usuario especifico.
     *
     * @param token token JWT a validar
     * @param userDetails detalles del usuario
     * @return true si el token es valido
     */
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    /**
     * Verifica si el token ha expirado.
     *
     * @param token token JWT
     * @return true si el token ha expirado
     */
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * Extrae la fecha de expiracion del token.
     *
     * @param token token JWT
     * @return fecha de expiracion
     */
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Extrae todos los reclamos del token JWT.
     *
     * @param token token JWT
     * @return todos los reclamos del token
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    /**
     * Obtiene la clave de firma utilizada para firmar y verificar tokens.
     *
     * @return clave de firma HMAC
     */
    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
