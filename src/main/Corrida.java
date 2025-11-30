package main;


public class Corrida  {
	private String id, origem, destino;
	private double distancia, valorTotal, tarifaBase, multiplicador;
	Motorista motorista;
	Passageiro passageiro;
	TipoCorrida tipo;
	StatusCorrida status;
	
	private void imprimirOrigem() {
		System.out.println("Origem: " + getOrigem() + ".");
	}
	private void imprimirDestino() {
		System.out.println("Destino: " + getDestino() + ".");
	}
	private void imprimirDistancia() {
		System.out.printf("Distancia corrida: %.2f km.\n", getDistancia()); 
	}
	private void imprimirValor() {
		System.out.printf("Valor corrida: R$ %.2f.\n", getValorTotal());
	}
	private void imprimirNomeMotorista() {
		System.out.println("Motorista: " +  motorista.getNome() + ".");
	}
	private void imprimirTipo() {
		if(tipo == TipoCorrida.Comum) {
			System.out.println("Tipo: Comum.");
			System.exit(0);
		} else {
			System.out.println("Tipo: Luxo.");
		}
		
	}
	public void imprimirNomePassageiro() {
		System.out.println("Passageiro: " + passageiro.getNome() + ".");
	}
	
	public void imprimirMenu() {
		System.out.println("--MENU DA CORRIDA--");
		imprimirOrigem();
		imprimirDestino();
		imprimirDistancia();
		imprimirTipo();
		imprimirValor();
		imprimirNomeMotorista();
		imprimirNomePassageiro();
	}
	public double calcularPreco() {
		this.iniciarValores();
		this.setValorTotal(tarifaBase + (multiplicador * distancia));
		return this.valorTotal;
	}
	
	private void iniciarValores() {
		if (this.tipo == TipoCorrida.Comum) {
			setTarifaBase(5);
			setMultiplicador(1);
		} else if (this.tipo == TipoCorrida.Luxo) {
			setTarifaBase(9);
			setMultiplicador(2.2);
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
