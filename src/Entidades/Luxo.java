package entidades;

public final class Luxo extends CategoriaServico {
	
	protected double calcularPreco(Corrida c) {
		setTarifaBase(9);
		setMultiplicador(2.2);
		return (getTarifaBase() + getMultiplicador() * c.getDistancia());
	}
}
