package br.edu.atitus.pooavancado.TrabalhoFinal.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;




@Entity
@Table(name = "Produto")
public class Produto extends GenericEntity{
	
	private String nome;

	private String Descricao;

	private String UnidadeMedida;
	
	private double valorUnitario;
	
	public String getNome()
	{
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao()
	{
		return this.Descricao;
	}
	
	public void setDescricao(String descricao) {
		this.Descricao = descricao;
	}

	public String getUnidadeMedida()
	{
		return this.UnidadeMedida;
	}
	
	public void setUnidadeMedida(String unidadeMedida) {
		this.UnidadeMedida = unidadeMedida;
	}
	
	
	public double getValorUnitario()
	{
		return this.valorUnitario;
	}
	
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	

}
