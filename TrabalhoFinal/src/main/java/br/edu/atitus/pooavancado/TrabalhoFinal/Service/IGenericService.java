package br.edu.atitus.pooavancado.TrabalhoFinal.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import br.edu.atitus.pooavancado.TrabalhoFinal.Respositorios.IGenericRepository;
import br.edu.atitus.pooavancado.TrabalhoFinal.Entidades.GenericEntity;

public interface IGenericService<TEntidade extends GenericEntity> {
	
	IGenericRepository<TEntidade> getRepository();
	
	default void validateSave(TEntidade objeto) throws Exception {

	}
	
	default TEntidade save(TEntidade objeto) throws Exception{
		this.validateSave(objeto);
		return this.getRepository().save(objeto);
	}
	
	default TEntidade findById(Long id) throws Exception{
		var objeto = getRepository().findById(id);
		if (objeto.isEmpty())
			throw new Exception("Não existe cadastro com o Id: " + id);
		return objeto.get();
	}
	
	default void deleteById(Long id) throws Exception{
		if (getRepository().existsById(id))
			throw new Exception("Não existe usuário com o Id: " + id);
		getRepository().deleteById(id);
	}

}