package entidades;

import java.util.ArrayList;

import java.util.List;

import java.util.Random;

import java.util.Scanner;

public class Passageiro extends Usuario {
	@SuppressWarnings("unused")
	private boolean pendenciaFinanceira;
	private List<MetodoDePagamento> metodosDePagamento = new ArrayList<>();
	
	public void AdicionarMetodoPagamento (MetodoDePagamento metodo) {
		metodosDePagamento.add(metodo);
		 }
	
	public boolean removerMetodoPagamento (MetodoDePagamento metodo) {
		 for (int i = 0; i < this.metodosDePagamento.size(); i++) {
			 	if(metodosDePagamento.get(i) == metodo) {
			 		metodosDePagamento.remove(i);
			 		return true;
			 	}
	 		}
		 return false;
		} 
	
	public Corrida solicitarCorrida() {
		String origem, destino;
		double distancia;
		Scanner sc = new Scanner(System.in);
		
		Random gerador = new Random();
		distancia = gerador.nextInt(49) + 1;
		origem = getString("Qual a origem?", sc);
		destino = getString("Qual a destino?", sc);
//		TipoCorrida tipoCorrida = escolherTipoCorrida();
		CategoriaServico categoria = escolherTipoCorrida();
		
		Corrida corrida = new Corrida(origem, destino, distancia, this, categoria);
		corrida.setValorTotal(corrida.categoria.calcularPreco(corrida));
		
		return corrida;
	}
	
	private CategoriaServico escolherTipoCorrida() {
		int num;
		CategoriaServico categoria = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Qual tipo de corrida?");
		System.out.println("1. Comum");
		System.out.println("2. Luxo");
		num = sc.nextInt();
		
		switch (num) {
			case 1:
				categoria = new Comum();
				 break;
			case 2:
				categoria = new Luxo();
				break;
			default:
				System.out.println("Escolha entre as duas opcoes (1/2).");
				break;
		}
		sc.close();
		return categoria;
	}
// 	private TipoCorrida escolherTipoCorrida() {
//		int num;
//		TipoCorrida tipo = null;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Qual tipo de corrida?");
//		System.out.println("1. Comum");
//		System.out.println("2. Luxo");
//		num = sc.nextInt();
//		switch (num) {
//			case 1:
//				 tipo = TipoCorrida.Comum;
//				 break;
//			case 2:
//				tipo = TipoCorrida.Luxo;
//				break;
//			default:
//				System.out.println("Escolha entre as duas opcoes (1/2).");
//				break;
//		}
//		sc.close();
//		return tipo;
//	}
	
	public boolean cancelarCorrida(Corrida corrida) {
		if (corrida.getPassageiro() == this) {
			corrida.status = StatusCorrida.Cancelada;
			// remover corrida da lista
			System.out.println("Corrida cancelada com sucesso.");
			return true;
		} else {
			System.out.println("O passageiro está tentando cancelar uma corrida que nao eh sua.");
			return false;
		}
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

	public void serAvaliado(Motorista avaliador, int nota, String comentario) {
		Avaliacao avaliacao = new Avaliacao(avaliador, this, nota, comentario);
        this.receberAvaliacao(avaliacao);
    }
	
}
