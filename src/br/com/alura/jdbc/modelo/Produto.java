package br.com.alura.jdbc.modelo;

public class Produto {

	private Integer id;
	private String nome;
	private String descricao;
	
	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getDescricao() {
		// TODO Auto-generated method stub
		return this.descricao;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
}
