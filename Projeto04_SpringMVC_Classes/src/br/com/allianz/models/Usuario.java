package br.com.allianz.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuario {

	@Id
	@Column(name="NOME")
	@NotNull
	@NotEmpty(message="{erro.usuario.descricao.vazio}")
	@Size(min=4,max=20,message="{erro.usuario.descricao.tamanho}")
	private String nome;	
	
	@Column(name="SENHA")
	@NotNull
	@NotEmpty(message="{erro.usuario.senha.vazio}")
	@Size(min=4,max=32,message="{erro.usuario.senha.tamanho}")	
	private String senha;

	@Column(name="NIVEL")
	private int nivel;

	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nome, String senha, int nivel) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.nivel = nivel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
}
