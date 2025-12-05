package entidades;

import exceptions.NegocioException;

public class Pix implements MetodoDePagamento {
	
	private String chavePix;

	public Pix(String chavePix) {
		this.chavePix = chavePix;
	}

	@Override
	public void processarPagamento(double valor) throws NegocioException {
		System.out.println("Processando pagamento de R$ " + valor + " via PIX para chave: " + chavePix);
		
		if (Math.random() < 0.05) {
            throw new NegocioException("Falha na comunicação com o sistema PIX.");
        }
		
		System.out.println("Pagamento de R$ " + valor + " via PIX concluído com sucesso.");
	}

}
