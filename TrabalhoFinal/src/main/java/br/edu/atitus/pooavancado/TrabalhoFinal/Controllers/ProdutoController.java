package br.edu.atitus.pooavancado.TrabalhoFinal.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.TrabalhoFinal.Entidades.Produto;
import br.edu.atitus.pooavancado.TrabalhoFinal.Service.IGenericService;
import br.edu.atitus.pooavancado.TrabalhoFinal.Service.IProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController extends GenericController<Produto> {
	
	final IProdutoService produtoService;
	
	public ProdutoController(IProdutoService produtoService) {
		super();
		this.produtoService = produtoService;
	}
	
	@Override
	IGenericService<Produto> getService() {
		return produtoService;
	}
	

}
