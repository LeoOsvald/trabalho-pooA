package br.edu.atitus.pooavancado.TrabalhoFinal.Respositorios;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.edu.atitus.pooavancado.TrabalhoFinal.Entidades.Usuario;

@Repository
public interface IUsuarioRepository extends IGenericRepository<Usuario>{

	Optional<Usuario> findByNomeUsuario(String nomeUsuario);
}