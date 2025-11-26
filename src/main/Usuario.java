package main;

public class Usuario {
	private String nome, cpf, email, telefone, senha;
	private double mediaAvaliacao;
	
	
	public boolean autenticar(String senha) {
		if (senha.equals(this.senha)) {
			System.out.println("Voce foi autenticado com sucesso.");
			return true;
		}
		System.out.println("Senha incorreta.");
		return false;
	}
	
	public Usuario() {}
	public Usuario(String nome) {
		super();
		this.nome = nome;
	}
	public Usuario(String nome, String cpf, String email, String telefone, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public double getMediaAvaliacao() {
		return mediaAvaliacao;
	}
}
