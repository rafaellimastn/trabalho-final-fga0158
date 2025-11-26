package main;


public class Corrida  {
	private String id, origem, destino;
	private double distancia, valorTotal;
	double tarifaBase, multiplicador;
	Motorista motorista;
	Passageiro passageiro;
	TipoCorrida tipo;
	StatusCorrida status;
	
	public void imprimirDistancia() {
		System.out.printf("Distancia total da corrida: R$ %.2f.\n", this.distancia); 
	}
	public void imprimirValor() {
		System.out.printf("Valor total da corrida: R$ %.2f\n", this.valorTotal);

	}
	public double calcularPreco() {
		this.iniciarValores();
		this.valorTotal = tarifaBase + (multiplicador * distancia);
		return this.valorTotal;
	}
	private void iniciarValores() {
		if (this.tipo == TipoCorrida.Comum) {
			tarifaBase = 5;
			multiplicador = 1;
		} else if (this.tipo == TipoCorrida.Luxo) {
			tarifaBase = 9;
			multiplicador = 2.2;
		}
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

	public TipoCorrida getTipo() {
		return tipo;
	}

	public void setTipo(TipoCorrida tipo) {
		this.tipo = tipo;
	}

	public Corrida(String origem, String destino, Passageiro passageiro, TipoCorrida tipo) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.passageiro = passageiro;
		this.tipo = tipo;
	}
	public Corrida(String origem, String destino, double distancia, Passageiro passageiro, TipoCorrida tipo) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
		this.passageiro = passageiro;
		this.tipo = tipo;
	}
	
}
