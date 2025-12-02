
package entidades;

public abstract class CategoriaServico {
	private double tarifaBase;
	private double multiplicador;
	
	protected abstract double calcularPreco(Corrida c);

	public double getTarifaBase() {
		return tarifaBase;
	}

	public void setTarifaBase(double tarifaBase) {
		this.tarifaBase = tarifaBase;
	}

	public double getMultiplicador() {
		return multiplicador;
	}

	public void setMultiplicador(double multiplicador) {
		this.multiplicador = multiplicador;
	}
	
}
