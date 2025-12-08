package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import entidades.*;
import servicos.GerenciadorDeCorridas;
import servicos.GerenciadorUsuario;

public class Main {
	public static final long MINUTO = 60000;
	public static final long SEGUNDO = 1000;
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
		Motorista m;
		gerenciadorUsuario.setListaDeMotoristas(criarListaMotoristas(gerenciadorCorridas));
		do {
			m = escolherMotorista(gerenciadorUsuario.getListaDeMotoristas());
		} while(m.getStatus() != StatusMotorista.Online);
		
		System.out.println("Deseja solicitar uma corrida?(S/N)");
		resposta = sc.next().toLowerCase().charAt(0);
		if (resposta == 'n') {
			System.out.println("Tudo bem, ate breve!");
			System.exit(2);
		}
		// metodos de pagamento 
		
		Pix metodo1 = new Pix(p.getEmail());
		p.adicionarMetodoPagamento(metodo1);
		CartaoCredito metodo2 = new CartaoCredito();
		p.adicionarMetodoPagamento(metodo2);
		Dinheiro metodo3 = new Dinheiro();
		p.adicionarMetodoPagamento(metodo3);
		
		MetodoDePagamento metodoPagamento = escolherMetodo(p, sc);
		System.out.println("Metodo de pagamento escolhido: " + metodoPagamento.getNome());
		
		// solicitando a corrida
		Corrida c = p.getGerenciadorCorridas().solicitarCorrida(p, metodoPagamento);
		c.imprimirMenu();
		c.getGerenciadorCorrida().iniciarCorrida(c);

		// Tempo de espera da corrida
		int intDistancia = (int)c.getDistancia();
		int dezenaDistancia = intDistancia / 10;
		try {
			// tempo de espera da corrida
			System.out.println("Tempo da corrida: " + (calcularMinutosCorrida(c) / MINUTO) + " minutos e " + (calcularSegundosCorrida(c) / SEGUNDO)
					+ " segundos.");
			long tempo = calcularMinutosCorrida(c);
			
			
			for(int i = 0; i < dezenaDistancia; i++) {
				Thread.sleep(MINUTO);
				System.out.println ("Distancia percorrida(km): " + 10 * (i + 1) + "/" + intDistancia + ".");
			}
			Thread.sleep(calcularSegundosCorrida(c));
			System.out.println("Distancia Percorrida(km): " + intDistancia + "/" + intDistancia);
		} catch (InterruptedException e) {
			// captura exceção se o thread for interrompido durante o sleep
			Thread.currentThread().interrupt(); 
			System.err.println("A corrida foi interrompida.");
		} 
		// processar pagamento
		p.getGerenciadorCorridas().pagarCorrida(c, metodoPagamento);
		
		c.getGerenciadorCorrida().finalizarCorrida(c);
		System.out.println("Corrida finalizada!");
		
		System.out.println("Deseja avliar o motorista?(S/N)");
		resposta = sc.next().toLowerCase().charAt(0);
		if (resposta == 's') {
			System.out.println("Qual a nota do motorista?");
			int nota = sc.nextInt();
			System.out.println("Escreve uma mensagem para o motorista");
			sc.next();
			
			String mensagem = sc.nextLine();
			Avaliacao a = new Avaliacao(p, m, nota, mensagem);
		}
		System.out.println("Nos agradecemos, ate breve!");	
	}
	
	private static long calcularSegundosCorrida(Corrida c) {
		int tempoSegundo;
		double distancia = c.getDistancia();
		int unidade = (int)distancia % 10;
		if(unidade <= 2) {
			tempoSegundo = 10; 
		} else if (unidade > 2 && distancia <= 4) {
			tempoSegundo = 20;
		} else if (unidade > 4 && distancia <= 6) {
			tempoSegundo = 30;
		} else if (unidade > 6 && distancia <= 8) {
			tempoSegundo = 40;
		} else {
			tempoSegundo = 50;
		}
		return tempoSegundo * SEGUNDO;
	}
	private static long calcularMinutosCorrida(Corrida c) {
		double distancia = c.getDistancia();
		int tempoMinuto;
		if (distancia <= 10) {
			tempoMinuto = 1;
		} else if (distancia > 10 && distancia <= 20 ){
			tempoMinuto = 2;
		} else if (distancia > 20 && distancia <= 30) {
			tempoMinuto = 3;
		} else if (distancia > 30 && distancia <= 40){
			tempoMinuto = 4;
		} else {
			tempoMinuto = 5;
		}
		return tempoMinuto * MINUTO;
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
	
	private static Motorista escolherMotorista(List<Motorista> lista) {
		Random gerador = new Random();
		int index = gerador.nextInt(25);
		return lista.get(index);
	}
	
	private static List<Motorista> criarListaMotoristas(GerenciadorDeCorridas gerenciador) {
		final String[] NOMES = {
		        "Ana", "Bruno", "Camila", "Daniel", "Eduarda", "Felipe", "Gabriela", "Henrique", 
		        "Isabela", "João", "Karina", "Lucas", "Manuela", "Nícolas", "Olívia", "Pedro", 
		        "Rafaela", "Thiago", "Vitória", "Rafael", "Larissa", "Marcelo", "Mariana", 
		        "Gustavo", "Sofia" 
		    };
		
		List<Motorista> lista = new ArrayList<Motorista>();
		for (int i = 0; i < NOMES.length; i++) { 
            String nome = NOMES[i];
            Motorista m = cadastrarMotorista(gerenciador, nome);
            lista.add(m);
        }
		return lista;
	}
	private static Motorista cadastrarMotorista(GerenciadorDeCorridas gerenciador, String nome) {
		Motorista m = new Motorista(gerenciador);
		m.setNome(nome);
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
