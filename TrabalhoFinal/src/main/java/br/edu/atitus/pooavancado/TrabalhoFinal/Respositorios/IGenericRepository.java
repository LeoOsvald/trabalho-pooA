package br.edu.atitus.pooavancado.TrabalhoFinal.Respositorios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import br.edu.atitus.pooavancado.TrabalhoFinal.Entidades.GenericEntity;

@NoRepositoryBean
public interface IGenericRepository <TEntidade extends GenericEntity> extends JpaRepository<TEntidade, Long>{
	
	Page<TEntidade> findById(long id, Pageable pageable);


}
