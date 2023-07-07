package br.edu.atitus.pooavancado.TrabalhoFinal.ServiceImpl;

import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.TrabalhoFinal.Entidades.Pedido;
import br.edu.atitus.pooavancado.TrabalhoFinal.Respositorios.IGenericRepository;
import br.edu.atitus.pooavancado.TrabalhoFinal.Respositorios.IPedidoRepository;
import br.edu.atitus.pooavancado.TrabalhoFinal.Service.IPedidoService;

@Service
public class PedidoServiceImpl implements IPedidoService {

	final IPedidoRepository pedidoRepository;
	public PedidoServiceImpl(IPedidoRepository pedidoRepository) {
		super();
		this.pedidoRepository = pedidoRepository;
	}
	
	@Override
	public IGenericRepository<Pedido> getRepository() {
		return pedidoRepository;
	}

	

}
