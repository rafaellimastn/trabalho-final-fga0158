package main;

import java.util.Scanner;

import entidades.*;
import servicos.GerenciadorDeCorridas;
import servicos.GerenciadorUsuario;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// Instanciar gerenciadores 
		GerenciadorUsuario gerenciadorUsuario = new GerenciadorUsuario();
		GerenciadorDeCorridas gerenciadorCorridas = new GerenciadorDeCorridas(gerenciadorUsuario);
		
		Scanner sc = new Scanner(System.in);
		// Menu Inicial
		System.out.println("--BEM VINDO AO SISTEMA DE RIDE-SHARING--\nDeseja se cadastrar?(S/N)");
		char resposta = sc.next().toLowerCase().charAt(0);
		if (resposta == 'n') {
			System.out.println("Tudo bem, ate breve!");
			System.exit(1);
		} 
		// cadastrar passagiro na lista de usuarios
		Passageiro p = cadastrarPassageiro();
		p.setGerenciadorCorridas(gerenciadorCorridas);
		p.getGerenciadorCorridas().getGerenciadorUsuario().CadastrarPassageiro(p);
		
		// cadastrar motorista na lista de usuarios
			// TODO
		
		System.out.println("Deseja solicitar uma corrida?(S/N)");
		resposta = sc.next().toLowerCase().charAt(0);
		if (resposta == 'n') {
			System.out.println("Tudo bem, ate breve!");
			System.exit(2);
		}
		
		// solicitando a corrida
		Corrida c = p.getGerenciadorCorridas().solicitarCorrida(p, null);
		c.imprimirMenu();
	}
	private static Passageiro cadastrarPassageiro() {
		Scanner sc2 = new Scanner(System.in);
		Passageiro p = new Passageiro();
		p.setNome(getString("Qual seu nome?", sc2));
		p.setCpf(getString("Qual seu cpf?", sc2));
		p.setEmail(getString("Qual seu email?", sc2)) ;
		p.setTelefone(getString("Qual seu telefone?", sc2));
		p.setSenha (getString("Qual sua senha?", sc2));
		return p;
	}
	
	private static String getString(String output, Scanner sc) {
		System.out.println(output);
		String resposta = sc.nextLine();
		return resposta;
	}
}
