package servicos;

import java.util.Random;
import java.util.Scanner;

import java.util.UUID;

// import com.sun.tools.javac.launcher.Main;

import entidades.*;

import exceptions.*;

public class GerenciadorDeCorridas {
	GerenciadorUsuario gerenciadorUsuario;	
	public Corrida solicitarCorrida(Passageiro passageiro, MetodoDePagamento metodoPagamento) throws NegocioException {
		
		if (passageiro.isPendenciaFinanceira()) {
			throw new NegocioException("Passageiro com pendências financeiras. Não é possível solicitar nova corrida.");
		} // tratar pendencia.
		
		// id corrida
		String id = UUID.randomUUID().toString().substring(0,8);
		
		// origem e destino da corrida
		Scanner sc = new Scanner(System.in);
		String origem = getString("Qual a origem?", sc);
		String destino = getString("Qual o destino?", sc);
		
		// Geração randomica da distancia da corrida
		Random gerador = new Random();
		double distancia = gerador.nextInt(49) + 1;
		
		CategoriaServico categoria = escolherCategoria(sc);
		
		Corrida corrida = new Corrida(id,  origem, destino, distancia, passageiro, categoria, metodoPagamento);
		corrida.setValorTotal();
		corrida.setGerenciadorCorrida(this);
		Motorista motorista = gerenciadorUsuario.selecionarMotorista();
		// if (motorista == null || motorista.getStatus() != StatusMotorista.Offline) {
		// 	throw new NenhumMotoristaDisponivelException("Nenhum motorista online disponível no momento.");
		// }
		
		motorista.aceitarCorrida(corrida);
		
		System.out.println("Corrida " + id + " foi solicitada e atribuída ao motorista " + motorista.getNome());
		return corrida;
	}
	
	public void iniciarCorrida(Corrida corrida) {
		if (corrida.getStatus() == StatusCorrida.Aceita) {
			corrida.setStatus(StatusCorrida.EmAndamento);
		} else {
			// Falha ao iniciar corrida(excpetion)
		}
	}
	private CategoriaServico escolherCategoria(Scanner sc) {
		CategoriaServico categoria;
		System.out.println("Qual a categoria da corrida?\n1 - Comum\n2 - Luxo");
		int n = sc.nextInt();
		switch(n) {
			case 1: 
				categoria = new Comum();
				break;
			case 2:
				categoria = new Luxo();
				break;
			default:
				System.out.println("Selecione 1 ou 2.");
				categoria = null;
				break;
		}
		return categoria;
	}
	
	private String getString(String output, Scanner sc) {
		System.out.println(output);
		String resposta = sc.nextLine();
		return resposta;
	}
	
	public void finalizarCorrida(Corrida corrida) throws EstadoInvalidoDaCorridaException,
	NegocioException {
		try {
		corrida.finalizarCorrida();
		
		if (corrida.getStatus() == StatusCorrida.Finalizada) {
			if (corrida.getMotorista() != null) {
				corrida.getMotorista().setStatus(StatusMotorista.Online);
			}
		}
		
		else if (corrida.getStatus() == StatusCorrida.PagamentoPendente) {
				if (corrida.getMotorista() != null) {
					corrida.getMotorista().setStatus(StatusMotorista.Online);
				}
		}
		
		} catch(NegocioException e) {
			System.err.println("Tratamento de Exceção no Gerenciador: Falha no pagamento da corrida "
					+ corrida.getValorTotal());
			throw e;
		} 
	}
	
	/* public void cancelarCorrida(Corrida corrida) throws EstadoInvalidoDaCorridaException {
		if (corrida.getStatus() != StatusCorrida.SOLICITADA) {
			throw new EstadoInvalidoDaCorridaException("Não é possível cancelar. A corrida já foi aceita ou está em andamento. "
					+ "Status atual: " + corrida.getStatus());
		}
		corrida.cancelar();
	}
	*/

	public GerenciadorDeCorridas(GerenciadorUsuario gerenciadorUsuario) {
		super();
		this.gerenciadorUsuario = gerenciadorUsuario;
	}
	
	public GerenciadorDeCorridas() {}

	public GerenciadorUsuario getGerenciadorUsuario() {
		return gerenciadorUsuario;
	}

	public void setGerenciadorUsuario(GerenciadorUsuario gerenciadorUsuario) {
		this.gerenciadorUsuario = gerenciadorUsuario;
	}	
}
