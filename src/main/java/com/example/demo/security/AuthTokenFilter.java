package com.example.demo.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class AuthTokenFilter extends OncePerRequestFilter {

	private static final Logger LOG = LoggerFactory.getLogger(AuthTokenFilter.class);

	@Autowired
	private JwtUtils jwtUtils;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// Validación de token valido para la autenticación
		try {
			String jwt = this.parseJwt(request);
			if (jwt != null && this.jwtUtils.validateJwtToken(jwt)) {
				// Como es valido el token le voy a autenticar
				String nombre = this.jwtUtils.getUsernameFromJwt(jwt);

				// Le autenticamos
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
						nombre, null, new ArrayList<>());
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				// Seteamos la autenticación en la sesión
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		} catch (Exception e) {
			LOG.error("No se pudo realizar la autenticación con el token enviado: {}", e.getMessage());
		}
		filterChain.doFilter(request, response);
	}

	// Obtener el token puro
	private String parseJwt(HttpServletRequest request) {
		String valorCompleto = request.getHeader("Authorization");
		if (StringUtils.hasText(valorCompleto) && valorCompleto.startsWith("Bearer ")) {
			return valorCompleto.substring(7, valorCompleto.length());
		}
		return null;
	}

}
