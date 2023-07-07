package br.edu.atitus.pooavancado.TrabalhoFinal.Entidades;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pedido")
public class Pedido extends GenericEntity{
	
	private Date Data;
	
	private long ProdutoId;
	
	private double Quantidade;
	
	
	
	private Date GetData() {
		
		return this.Data;
	}
	
	private void setDate(Date data)
	{
		this.Data = data;
	}
	
	
	private double GetQuantidade() {
		
		return this.Quantidade;
	}
	
	private void setQuantidade(double quantidade)
	{
		this.Quantidade = quantidade;
	}
	
	
	private long GetProdutoId() {
		
		return this.ProdutoId;
	}
	
	private void setProdutoId(long produtoId)
	{
		this.ProdutoId = produtoId;
	}
	
	
	

}
