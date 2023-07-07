package br.edu.atitus.pooavancado.TrabalhoFinal.Config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.edu.atitus.pooavancado.TrabalhoFinal.Entidades.Usuario;
import br.edu.atitus.pooavancado.TrabalhoFinal.Service.IUsuarioService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {
	private final JwtConfig jwtConfig;
	private final IUsuarioService usuarioService;

	public AuthTokenFilter(JwtConfig jwtConfig, IUsuarioService usuarioService) {
		super();
		this.jwtConfig = jwtConfig;
		this.usuarioService = usuarioService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException 
	{
		try {
			String jwt = jwtConfig.getJwtFromRequest(request);
			if (jwt != null && jwtConfig.validaJwtToken(jwt)) {
				String username = jwtConfig.getUsernameFromJwtToken(jwt);
				Usuario usuario = (Usuario) usuarioService.loadUserByUsername(username);

				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario,
						null, usuario.getAuthorities());

				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(authentication);

			}
		} catch (Exception e) {

		}

		filterChain.doFilter(request, response);

	}

}
