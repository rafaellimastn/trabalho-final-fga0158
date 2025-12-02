package entidades;


public class Corrida  {
	private String id, origem, destino;
	private double distancia, valorTotal, tarifaBase, multiplicador;
	Motorista motorista;
	Passageiro passageiro;
	StatusCorrida status;
	CategoriaServico categoria;
	
	public void imprimirMenu() {
		System.out.println("--MENU DA CORRIDA--");
		imprimirOrigem();
		imprimirDestino();
		imprimirDistancia();
		imprimirCategoria();
		imprimirValor();
		imprimirNomePassageiro();
		imprimirNomeMotorista();
	}
	
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
	private void imprimirCategoria() {
		if (categoria instanceof Comum) {
			System.out.println("Tipo: Comum.");
		} else if (categoria instanceof Luxo){
			System.out.println("Tipo: Luxo.");
		} else {
			System.out.println("Categoria não foi escolhida.");
		}
	}
	
	private void imprimirNomePassageiro() {
		System.out.println("Passageiro: " + passageiro.getNome() + ".");
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

	public StatusCorrida getStatus() {
		return status;
	}
	public void setStatus(StatusCorrida status) {
		this.status = status;
	}

	public Corrida(String origem, String destino, double distancia, Passageiro passageiro, CategoriaServico categoria) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
		this.passageiro = passageiro;
		this.categoria = categoria;
	}
	
}
