package servicos;

import java.util.UUID;

import entidades.*;
import exceptions.*;

public class GerenciadorDeCorridas {
	
	public GerenciadorDeCorridas(Motorista motoristaDisponivel) {
		this.motoristaDisponivel = motoristaDisponivel;
	}
	
	public void solicitarCorrida(Passageiro passageiro, String origem, 
			String destino, double distanciaKm, CategoriaServico categoria, MetodoDePagamento metodoPagamento) throws NegocioException {
		
		if (passageiro.temPendenciaFinanceira()) {
			throw new NegocioException("Passageiro com pendências financeiras. Não é possível solicitar nova corrida.");
		}
		
		if (motoristaDisponivel == null || motoristaDisponivel.getStatusDisponibilidade() != StatusMotorista.ONLINE) {
            throw new NenhumMotoristaDisponivelException("Nenhum motorista online disponível no momento.");
		}
		
//		String id = UUID.randomUUID().toString().substring(0,8);
//		Corrida novaCorrida = new Corrida(id,  origem, destino, distanciaKm, passageiro, categoria);
//		
//		novaCorrida.setMotorista(motoristaDisponivel);
//		motoristaDisponivel.aceitarCorrida(novaCorrida);
//		novaCorrida.setStatus(StatusCorrida.Aceita);
//		
//		System.out.println("Corrida " + id + "solicitada e atribuída ao motorista " + motoristaDisponivel.getNome());
//		return novaCorrida;
	}
	
	public void iniciarViagem(Corrida corrida) throws EstadoInvalidoDaCorridaException {
		corrida.iniciarViagem();
	}
	
	public void finalizarViagem(Corrida corrida) throws EstadoInvalidoDaCorridaException,
	NegocioException{
		try {
		corrida.finalizarViagem();
		
		if (corrida.getStatus() == StatusCorrida.FINALIZADA) {
			if (corrida.getMotorista() != null) {
				corrida.getMotorista().setStatus(StatusMotorista.ONLINE);
			}
		}
		
		else if (corrida.getStatus() == StatusCorrida.PENDENTE_PAGAMENTO) {
				if (corrida.getMotorista != null) {
					corrida.getMotorista().setStatus(StatusMotorista.ONLINE);
				}
		}
		
		} catch(NegocioException e) {
			System.err.println("Tratamento de Exceção no Gerenciador: Falha no pagamento da corrida "
					+ corrida.getValorTotal());
			throw e;
		} 
	}
	
	public void cancelarCorrida(Corrida corrida) throws EstadoInvalidoDaCorridaException {
		if (corrida.getStatus() != StatusCorrida.SOLICITADA) {
			throw new EstadoInvalidoDaCorridaException("Não é possível cancelar. A corrida já foi aceita ou está em andamento. "
					+ "Status atual: " + corrida.getStatus());
		}
		corrida.cancelar();
	}
	
	
}
