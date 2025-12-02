package entidades;

public final class Comum extends CategoriaServico{
	
	protected double calcularPreco(Corrida c) {
		setTarifaBase(5);
		setMultiplicador(1);
		return (getTarifaBase() + getMultiplicador() * c.getDistancia());
	}
}
