package entidades;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nome, cpf, email, telefone, senha;
	private double mediaAvaliacao;

	private List<Avaliacao> avaliacoes = new ArrayList<>();
	
	public void  cadastrar() {
		Scanner sc = new Scanner(System.in);
		setNome(getString("Qual seu nome?", sc));
		setCpf(getString("Qual seu cpf?", sc));
		setEmail(getString("Qual seu email?", sc)) ;
		setTelefone(getString("Qual seu telefone?", sc));
		setSenha (getString("Qual sua senha?", sc));
	}
	
	String getString(String output, Scanner sc) {
		System.out.println(output);
		String resposta = sc.nextLine();
		return resposta;
	}
	
	public boolean autenticar(String senha) {
		if (senha.equals(this.senha)) {
			System.out.println("Voce foi autenticado com sucesso.");
			return true;
		}
		System.out.println("Senha incorreta.");
		return false;
	}
	
	public Usuario() {}
	// apagar pos teste
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

// avaliação

	public void receberAvaliacao(Avaliacao avaliacao) {
		if (avaliacao != null) {
			avaliacoes.add(avaliacao);
			calcularMedia();
		}
	}

	private void calcularMedia() {
		if (avaliacoes.isEmpty()) {
			this.mediaAvaliacao = 0;
			return;
		}

		double soma = 0;
		for (Avaliacao a : avaliacoes) {
			soma += a.getNota();
		}
		this.mediaAvaliacao = soma / avaliacoes.size();
	}

	public double getMediaAvaliacao() {
		return mediaAvaliacao;
	}

}
