package br.com.alura.jdbc.modelo;

import java.util.List;

public class Categoria {
	private int id;
	private String nome;
	private List<Produto> produtos;

	public Categoria(String nome) {
		this.nome = nome;
	}

	public Categoria(int id, String nome) {
		this.nome = nome;
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {

		return String.format("%d - %s", this.id, this.nome);
	}

	public void adicionaProduto(Produto poduto) {
		this.produtos.add(poduto);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

}
