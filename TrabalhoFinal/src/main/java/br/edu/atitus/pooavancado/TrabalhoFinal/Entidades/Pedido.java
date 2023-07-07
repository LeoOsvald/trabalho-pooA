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
	
	
	public long GetProdutoId() {
		
		return this.ProdutoId;
	}
	
	public void setProdutoId(long produtoId)
	{
		this.ProdutoId = produtoId;
	}
	
	
	

}
