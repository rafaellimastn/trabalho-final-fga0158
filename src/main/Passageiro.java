package main;

import java.util.Random;

import java.util.Scanner;

public class Passageiro extends Usuario {
//	private boolean pendenciaFinanceira;
	
	public Corrida solicitarCorrida() {
		String origem, destino;
		long distancia;
		Scanner sc = new Scanner(System.in);
		
		Random gerador = new Random();
		distancia = gerador.nextInt(49) + 1;
		origem = getString("Qual a origem?", sc);
		destino = getString("Qual a destino?", sc);
		TipoCorrida tipoCorrida = setTipoCorrida();
		
		Corrida corrida = new Corrida(origem, destino, distancia, this, tipoCorrida);
		corrida.setValorTotal(corrida.calcularPreco());
		
		return corrida;
	}
	
	private TipoCorrida setTipoCorrida() {
		int num;
		TipoCorrida tipo = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Qual tipo de corrida?");
		System.out.println("1. Comum");
		System.out.println("2. Luxo");
		num = sc.nextInt();
		switch (num) {
			case 1:
				 tipo = TipoCorrida.Comum;
				 break;
			case 2:
				tipo = TipoCorrida.Luxo;
				break;
			default:
				System.out.println("Escolha entre as duas opcoes;");
				break;
		}
		sc.close();
		return tipo;
	}
	public boolean cancelarCorrida(Corrida corrida) {
		if (corrida.getPassageiro() == this) {
			corrida.status = StatusCorrida.Cancelada;
			System.out.println("Corrida cancelada com sucesso.");
			return true;
		} else {
			System.out.println("O passageiro está tentando cancelar uma corrida que nao eh sua.");
			return false;
		}
	}
//	private String getString(String output, Scanner sc) {
//		System.out.println(output);
//		String resposta = sc.next();
//		return resposta;
//	}
	
	public Passageiro() {
		super();
	}
	public Passageiro(String nome, String cpf, String email, String telefone, String senha) {
		super(nome, cpf, email, telefone, senha);
	}
	public Passageiro(String nome) {
		super(nome);
	}
	
}
