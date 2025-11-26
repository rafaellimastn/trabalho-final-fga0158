package main;

public class Main {
	public static void main(String[] args) {
		Passageiro p = new Passageiro("Rafael");
		Corrida c = p.solicitarCorrida();
		c.imprimirDistancia();
		c.imprimirValor();
	}
}
