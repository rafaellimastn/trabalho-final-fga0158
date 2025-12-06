package main;

import java.util.Scanner;

import entidades.*;
import servicos.GerenciadorDeCorridas;
import servicos.GerenciadorUsuario;

public class Main {
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
		
		// cadastrar passageiro na lista de usuarios
		Passageiro p = cadastrarPassageiro(sc);
		sc.next();
		
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
		Corrida c = p.getGerenciadorCorridas().solicitarCorrida(p, /* metodo de pagamento*/ null);
		c.imprimirMenu();
	}
	private static Passageiro cadastrarPassageiro(Scanner sc) {
		Passageiro p = new Passageiro();
		p.setNome(getString("Qual seu nome?", sc));
		p.setCpf(getString("Qual seu cpf?", sc));
		p.setEmail(getString("Qual seu email?", sc)) ;
		p.setTelefone(getString("Qual seu telefone?", sc));
		p.setSenha (getString("Qual sua senha?", sc));
		return p;
	}
	
	private static String getString(String output, Scanner sc) {
		System.out.println(output);
		String resposta = sc.nextLine();
		return resposta;
	}
}
