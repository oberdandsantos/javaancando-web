package br.com.allianz.models;

public class Convidado {

	private String cpf;
	private Evento evento;
	private String nome;
	private String email;
	private String telefone;
	
	
	public Convidado() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Convidado(String cpf, Evento evento, String nome, String email, String telefone) {
		super();
		this.cpf = cpf;
		this.evento = evento;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
}
