package br.edu.atitus.pooavancado.TrabalhoFinal.Entidades;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pedido")
public class Pedido extends GenericEntity{
	
	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	public double getQuantidade() {
		return Quantidade;
	}

	
	public Produto getProduto() {
		return Produto;
	}

	public void setProduto(Produto produto) {
		Produto = produto;
	}

	
	
	private Date Data;
	
	@ManyToOne
	@JoinColumn(name = "ProdutoId")
	private Produto Produto;
	
	private double Quantidade;
	
	
	
	

	
	
	
	

}
