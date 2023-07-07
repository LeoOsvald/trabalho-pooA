package br.edu.atitus.pooavancado.TrabalhoFinal.ServiceImpl;

import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.TrabalhoFinal.Entidades.Produto;
import br.edu.atitus.pooavancado.TrabalhoFinal.Respositorios.IGenericRepository;
import br.edu.atitus.pooavancado.TrabalhoFinal.Respositorios.IProdutoRepository;
import br.edu.atitus.pooavancado.TrabalhoFinal.Service.IProdutoService;

@Service
public class ProdutoServiceImpl implements IProdutoService {

	final IProdutoRepository produtoRepository;
	public ProdutoServiceImpl(IProdutoRepository produtoRepository) {
		super();
		this.produtoRepository = produtoRepository;
	}
	
	@Override
	public IGenericRepository<Produto> getRepository() {
		return produtoRepository;
	}

	

}
