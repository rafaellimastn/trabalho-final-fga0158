package main;

public class Main {
	public static void main(String[] args) {
		Passageiro p = new Passageiro("Rafael");
		Corrida c = p.solicitarCorrida();
		System.out.println(c.getOrigem());
		System.out.println(c.getDestino());
		System.out.println(c.getTipo());
	}
}
