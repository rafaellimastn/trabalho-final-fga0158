package entidades;

public class Motorista extends Usuario{
	
	private CNH cnh;
	private StatusMotorista status;
	Veiculo veiculo;
	
	public void iniciarCorrida(Corrida corrida) {
		corrida.setStatus(StatusCorrida.EmAndamento);
		 System.out.println("Corrida " + corrida.getStatus() );
		 }
	
	public void finalizarCorrida(Corrida corrida) {
		corrida.setStatus(StatusCorrida.Finalizada);
		 System.out.println("Corrida " + corrida.getStatus() );
	 }

	public boolean cancelarCorrida(Corrida corrida) {
		corrida.setStatus(StatusCorrida.Cancelada);
//		for (int i = 0; i < ListaDeCorridas.size(); i++) {
//			if(ListaDeCorridas.get(i).equals(corrida)) {
//				ListaDeCorridas.remove(i);
//				return true;
//				break;
		return true;
		}
	
	public boolean aceitarCorrida(Corrida corrida) {
		if (this.status == StatusMotorista.Online) {
			corrida.setMotorista(this);
			return true;
			} else {
				System.out.println("O motorista " + this.getNome() + " nao esta disponivel.");
				return false;
			}
		}
	
	public Motorista(String nome, String cpf, String email, String telefone, String senha, CNH cnh, Veiculo veiculo) {
		super(nome, cpf, email, telefone, senha);
		this.cnh = cnh;
		this.veiculo = veiculo;
		this.status = StatusMotorista.Offline;
		ListaDeMotoristas.add(this)
	}
	public Motorista(String nome) {
		super(nome);
	}
	
	public CNH getCnh() {
		return cnh;
	}
	public void setCnh(CNH cnh) {
		this.cnh = cnh;
	}
	public StatusMotorista getStatus() {
		return status;
	}
	public void setStatus(StatusMotorista status) {
		this.status = status;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	//AVALIAÇÃO
	public void serAvaliado(Passageiro avaliador, int nota, String comentario) {
		Avaliacao avaliacao = new Avaliacao(avaliador, this, nota, comentario);
        this.receberAvaliacao(avaliacao);
    }
}


