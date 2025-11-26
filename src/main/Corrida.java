package main;

public class Corrida  {
	private String id, origem, destino, tipo;
	private double distancia, valorTotal;
	double tarifaBase, multiplicador;
	Motorista motorista;
	Passageiro passageiro;
	StatusCorrida status;
	
	public void tipoCorrida() {
		if (tipo.equalsIgnoreCase("origem")) {
			tarifaBase = 5;
			multiplicador = 1;
		} else {
			tarifaBase = 9;
			multiplicador = 2;
		}
	}
	public double calcularPreco() {
		double total;
		total = tarifaBase + (multiplicador * distancia);
		this.valorTotal = total;
		return total;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

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

	public Corrida(String origem, String destino, String tipo, Passageiro passageiro) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.tipo = tipo;
		this.passageiro = passageiro;
	}
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	public Passageiro getPassageiro() {
		return passageiro;
	}
	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}
	
}
