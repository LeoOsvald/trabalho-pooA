package br.edu.atitus.pooavancado.TrabalhoFinal.Entidades;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pedido")
public class Pedido extends GenericEntity{
	
	private Date Data;
	
	@ManyToOne
	@JoinColumn(name = "ProdutoId")
	private Produto Produto;
	
	private double Quantidade;
	
	
	
	public Date GetData() {
		
		return this.Data;
	}
	
	public void setDate(Date data)
	{
		this.Data = data;
	}
	
	
	public double GetQuantidade() {
		
		return this.Quantidade;
	}
	
	public void setQuantidade(double quantidade)
	{
		this.Quantidade = quantidade;
	}
	
	
	
	

}
