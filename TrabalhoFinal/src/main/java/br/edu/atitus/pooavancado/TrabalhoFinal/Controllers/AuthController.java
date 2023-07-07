package br.edu.atitus.pooavancado.TrabalhoFinal.Controllers;

import java.security.SecureRandom;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.atitus.pooavancado.TrabalhoFinal.Config.ConfigSecurity;
import br.edu.atitus.pooavancado.TrabalhoFinal.Config.JwtConfig;
import br.edu.atitus.pooavancado.TrabalhoFinal.Controllers.Payload.LoginPayload;
import br.edu.atitus.pooavancado.TrabalhoFinal.Controllers.Payload.SignUpPayload;
import br.edu.atitus.pooavancado.TrabalhoFinal.Entidades.Usuario;
import br.edu.atitus.pooavancado.TrabalhoFinal.Service.IUsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
	
	
	private final IUsuarioService usuarioService;
	private final AuthenticationManager authenticationManager;
	private final JwtConfig jwtConfig;
	

	public AuthController(
			IUsuarioService usuarioService
			, AuthenticationManager authenticationManager
			, JwtConfig jwtConfig) 
	{
		super();
		this.usuarioService = usuarioService;
		this.authenticationManager = authenticationManager;
		this.jwtConfig = jwtConfig;
	}
	@PostMapping("/signin")
	public ResponseEntity<Object> login(@RequestBody LoginPayload login) {
		try {
			Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getNomeUsuario(), login.getSenha()));
			String jwt = jwtConfig.generateTokenFromUsername(login.getNomeUsuario());
			return ResponseEntity.status(HttpStatus.OK).body(jwt);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	@PostMapping("/signup")
	public ResponseEntity<Object> autoCadastro(@RequestBody SignUpPayload signup) {
		try {
			Usuario usuarioNovo = new Usuario();
			usuarioNovo.setNome(signup.getNomeUsuario());
			String senha = gerarSenhaAleatoria(10);
			usuarioNovo.setSenha(senha);
			usuarioService.save(usuarioNovo);
			return ResponseEntity.status(HttpStatus.OK).body(senha);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}
	private String gerarSenhaAleatoria(int tamanho) {
		String CARACTERES_PERMITIDOS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        SecureRandom random = new SecureRandom();
        StringBuilder senha = new StringBuilder(tamanho);

        for (int i = 0; i < tamanho; i++) {
            int indice = random.nextInt(CARACTERES_PERMITIDOS.length());
            senha.append(CARACTERES_PERMITIDOS.charAt(indice));
        }
        return senha.toString();
    }
	

}