package entidades;

import exceptions.NegocioException;

public class Pix implements MetodoDePagamento {
	
	private String chavePix;

	public Pix(String chavePix) {
		this.chavePix = chavePix;
	}

	@Override
	public void processarPagamento(double valor) throws NegocioException {
		int intValor = (int) valor;
		System.out.println("Processando pagamento de R$ " + intValor + ",00 via PIX para chave: " + chavePix);
		
		if (Math.random() < 0.05) {
            throw new NegocioException("Falha na comunicação com o sistema PIX.");
        }
		
		System.out.println("Pagamento de R$ " + intValor + ",00 via PIX concluído com sucesso.");
	}
	public String getNome() {
		return "Pix";
	}
}
