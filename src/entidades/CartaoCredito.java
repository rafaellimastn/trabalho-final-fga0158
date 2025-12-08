package entidades;

import exceptions.NegocioException;
import exceptions.PagamentoRecusadoException;

public class CartaoCredito implements MetodoDePagamento {

	@SuppressWarnings("unused")
	private String numero, validade, codigoSeguranca;
	
	public CartaoCredito() {}
	
	public CartaoCredito(String numero, String validade, String codigoSeguranca) {
		this.numero = numero;
		this.validade = validade;
		this.codigoSeguranca = codigoSeguranca; 
	}

	@Override
	public void processarPagamento(double valor) throws NegocioException {
		int intValor = (int) valor;
		System.out.println("Processando pagamento de R$ " + intValor + ",00 via Cartão de Crédito");
		
		if (Math.random() < 0.1) {
            throw new PagamentoRecusadoException("Pagamento de R$ " + intValor + ",00 recusado pela operadora do cartão.");
        }
		
		
		System.out.println("Pagamento de R$ " + intValor + ",00 via Cartão de Crédito aprovado");
	}
	public String getNome() {
		return "Cartao de credito";
	}
}
	

