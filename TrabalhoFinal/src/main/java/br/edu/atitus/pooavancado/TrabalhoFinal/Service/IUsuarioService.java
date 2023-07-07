package br.edu.atitus.pooavancado.TrabalhoFinal.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.edu.atitus.pooavancado.TrabalhoFinal.Entidades.Usuario;

public interface IUsuarioService extends IGenericService<Usuario>, UserDetailsService {

}
