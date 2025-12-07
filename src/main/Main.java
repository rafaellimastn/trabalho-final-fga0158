package main;

import java.util.Scanner;

import entidades.*;
import servicos.GerenciadorDeCorridas;
import servicos.GerenciadorUsuario;

public class Main {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Instanciar gerenciadores 
		GerenciadorUsuario gerenciadorUsuario = new GerenciadorUsuario();
		GerenciadorDeCorridas gerenciadorCorridas = new GerenciadorDeCorridas(gerenciadorUsuario);
		
		Scanner sc = new Scanner(System.in);
		// Menu Inicial
		System.out.println("--BEM VINDO AO SISTEMA DE RIDE-SHARING--\nDeseja se cadastrar?(S/N)");
		char resposta = sc.next().toLowerCase().charAt(0);
		sc.nextLine();
		if (resposta == 'n') {
			System.out.println("Tudo bem, ate breve!");
			System.exit(1);
		} 
		// cadastrar passageiro na lista de usuarios
		Passageiro p = cadastrarPassageiro(gerenciadorCorridas, sc);

		// cadastrar motorista na lista de usuarios
		Motorista m = cadastrarMotorista(gerenciadorCorridas, sc);
		
		System.out.println("Deseja solicitar uma corrida?(S/N)");
		resposta = sc.next().toLowerCase().charAt(0);
		if (resposta == 'n') {
			System.out.println("Tudo bem, ate breve!");
			System.exit(2);
		}
		// metodos genericos d pagamento para teste
		Pix metodo1 = new Pix(p.getEmail());
		p.adicionarMetodoPagamento(metodo1);
		CartaoCredito metodo2 = new CartaoCredito();
		p.adicionarMetodoPagamento(metodo2);
		
		MetodoDePagamento metodo = escolherMetodo(p, sc);
		System.out.println("Metodo de pagamento escolhido: " + metodo.getNome());
		
		// solicitando a corrida
		Corrida c = p.getGerenciadorCorridas().solicitarCorrida(p, metodo);
		c.imprimirMenu();
		c.getGerenciadorCorrida().iniciarCorrida(c);
	}
	
	private static MetodoDePagamento escolherMetodo(Passageiro p, Scanner sc) {
		System.out.println("Qual metodo de pagamento voce deseja escolher?");
		
		for(MetodoDePagamento metodo : p.getMetodosDePagamento()) {
			int i = p.getMetodosDePagamento().indexOf(metodo) + 1;
			System.out.println(i + ". " + metodo.getNome());
		}
		int n = sc.nextInt();
		return p.getMetodosDePagamento().get(n - 1);
	}
	private static Motorista cadastrarMotorista(GerenciadorDeCorridas gerenciador, Scanner sc) {
		Motorista m = new Motorista(gerenciador);
		m.setNome("Felipe");
		m.getGerenciadorCorridas().getGerenciadorUsuario().CadastrarMotorista(m);
		m.setStatus(StatusMotorista.Online);
		
		return m;
	}
	
	private static Passageiro cadastrarPassageiro( GerenciadorDeCorridas gerenciador, Scanner sc) {
		Passageiro p = new Passageiro(gerenciador);
		p.setNome(getString("Qual seu nome?", sc));
		p.setCpf(getString("Qual seu cpf?", sc));
		p.setEmail(getString("Qual seu email?", sc)) ;
		p.setTelefone(getString("Qual seu telefone?", sc));
		p.setSenha (getString("Qual sua senha?", sc));
		p.getGerenciadorCorridas().getGerenciadorUsuario().CadastrarPassageiro(p);
		return p;
	}
	
	private static String getString(String output, Scanner sc) {
		System.out.println(output);
		String resposta = sc.nextLine();
		return resposta;
	}
}
