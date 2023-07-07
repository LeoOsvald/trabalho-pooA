package br.edu.atitus.pooavancado.TrabalhoFinal.ServiceImpl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.TrabalhoFinal.Entidades.Usuario;
import br.edu.atitus.pooavancado.TrabalhoFinal.Respositorios.IGenericRepository;
import br.edu.atitus.pooavancado.TrabalhoFinal.Respositorios.IUsuarioRepository;
import br.edu.atitus.pooavancado.TrabalhoFinal.Service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	final IUsuarioRepository usuarioRepository;

	public UsuarioServiceImpl(IUsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public IGenericRepository<Usuario> getRepository() {
		return usuarioRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByNomeUsuario(username).orElseThrow(
				() -> new UsernameNotFoundException("Não foi possível localizar o usuário com este e-mail"));
		return usuario;
	}

}
