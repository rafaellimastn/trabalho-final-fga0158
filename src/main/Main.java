package main;

public class Main {
	public static void main(String[] args) {
		Passageiro p = new Passageiro("Rafael");
		Motorista m = new Motorista("Felipe");
		Corrida c = p.solicitarCorrida();
		c.setMotorista(m);

		c.imprimirMenu();
	}
}
