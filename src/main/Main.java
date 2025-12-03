package main;

import java.util.Scanner;

import entidades.*;

public class Main {
	public static void main(String[] args) {
		// tela inicial
		Scanner sc = new Scanner(System.in);
		System.out.println("--BEM VINDO AO SISTEMA DE RIDE-SHARING--\nDeseja se cadastrar?(S/N)");
		char resposta = sc.next().toLowerCase().charAt(0);
		if (resposta == 'n') {
			System.out.println("Tudo bem, ate breve!");
			System.exit(1);
		} 
		Passageiro p = cadastrarPassageiro();	
		System.out.println("Deseja solicitar uma corrida?(S/N)");
		resposta = sc.next().toLowerCase().charAt(0);
		if (resposta == 'n') {
			System.out.println("Tudo bem, ate breve!");
		}
		Corrida c = p.solicitarCorrida();
		
		Motorista c = cadastrarMotorista();
		c.imprimirMenu();
	}
	private static Motorista cadastrarMotorista() {
		Scanner sc3 = new Scanner(System.in);
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
