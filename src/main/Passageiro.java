package main;

import java.util.Scanner;

public class Passageiro extends Usuario {
//	private boolean pendenciaFinanceira;
	
	public Corrida solicitarCorrida() {
		String origem, destino, tipo;
		Scanner sc = new Scanner(System.in);
		origem = getString("Qual a origem?", sc);
		destino = getString("Qual a destino?", sc);
		tipo = getString("Qual a tipo?", sc);
		Corrida corrida = new Corrida(origem, destino, tipo, this);
		corrida.tipoCorrida();
		return corrida;
	}
	public boolean cancelarCorrida(Corrida corrida) {
		if (corrida.getPassageiro() == this) {
			// cancela
			corrida.status = StatusCorrida.Cancelada;
			System.out.println("Corrida cancelada com sucesso.");
			return true;
		} else {
			System.out.println("O passageiro está tentando cancelar uma corrida que nao eh sua.");
			return false;
		}
	}
	private String getString(String output, Scanner sc) {
		System.out.println(output);
		String resposta = sc.next();
		return resposta;
	}
	
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
