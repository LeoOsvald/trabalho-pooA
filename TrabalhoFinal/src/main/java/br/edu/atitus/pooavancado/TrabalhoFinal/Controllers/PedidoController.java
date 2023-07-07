package br.edu.atitus.pooavancado.TrabalhoFinal.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.TrabalhoFinal.Entidades.Pedido;
import br.edu.atitus.pooavancado.TrabalhoFinal.Service.IGenericService;
import br.edu.atitus.pooavancado.TrabalhoFinal.Service.IPedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController extends GenericController<Pedido> {
	
	final IPedidoService pedidoService;
	
	public PedidoController(IPedidoService pedidoService) {
		super();
		this.pedidoService = pedidoService;
	}
	
	@Override
	IGenericService<Pedido> getService() {
		return pedidoService;
	}
	

}
