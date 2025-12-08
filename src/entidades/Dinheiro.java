package entidades;

import exceptions.SaldoInsuficienteException;

public class Dinheiro implements MetodoDePagamento {
    private int saldo = 100; 

	@Override
	public void processarPagamento(double valor) throws SaldoInsuficienteException {
		int intValor = (int) valor;
		System.out.println("Processando pagamento de R$ " + intValor + ",00 via Saldo/Dinheiro...");
		
		if (valor > saldo) {
			throw new SaldoInsuficienteException("Saldo insuficiente. Saldo atual: R$ " + saldo + ". Valor da corrida: R$ " + intValor + ",00");
		}
		
		saldo -= valor;
		System.out.println("Pagamento de R$ " + intValor + ",00 via Saldo/Dinheiro aprovado. Novo saldo: R$ " + saldo);
	}
	public String getNome() {
		return "Dinheiro";
	}
}
