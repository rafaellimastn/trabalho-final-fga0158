package entidades;

import exceptions.NegocioException;
import exceptions.PagamentoRecusadoException;

public class CartaoCredito implements MetodoDePagamento {

	@SuppressWarnings("unused")
	private String numero, validade, codigoSeguranca;
	
	public CartaoCredito(String numero, String validade, String codigoSeguranca) {
		this.numero = numero;
		this.validade = validade;
		this.codigoSeguranca = codigoSeguranca; 
	}

	@Override
	public void processarPagamento(double valor) throws NegocioException {
		System.out.println("Processando pagamento de R$ " + valor + " via Cartão de Crédito");
	
		if (Math.random() < 0.1) {
            throw new PagamentoRecusadoException("Pagamento de R$ " + valor + " recusado pela operadora do cartão.");
        }
		
		System.out.println("Pagamento de R$ " + valor + " via Cartão de Crédito aprovado");
	}
	
	}
	

