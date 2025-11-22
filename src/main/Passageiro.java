package main;

public class Passageiro extends Usuario {
	private boolean pendenciaFinanceira;
	public void solicitarCorrida() {
		
	}
	public boolean isPendenciaFinanceira() {
		return pendenciaFinanceira;
	}

	public void setPendenciaFinanceira(boolean pendenciaFinanceira) {
		this.pendenciaFinanceira = pendenciaFinanceira;
	}
}
