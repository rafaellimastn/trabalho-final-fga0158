package entidades;

import exceptions.SaldoInsuficienteException;

public class Dinheiro implements MetodoDePagamento {
    private double saldo = 100.00; 

	
	public Dinheiro() {
		//vazio
	}

	@Override
	public void processarPagamento(double valor) throws SaldoInsuficienteException {
		System.out.println("Processando pagamento de R$ " + valor + " via Saldo/Dinheiro...");
		
		if (valor > saldo) {
			throw new SaldoInsuficienteException("Saldo insuficiente. Saldo atual: R$ " + saldo + ". Valor da corrida: R$ " + valor);
		}
		
		saldo -= valor;
		System.out.println("Pagamento de R$ " + valor + " via Saldo/Dinheiro aprovado. Novo saldo: R$ " + saldo);
	}
	

}
