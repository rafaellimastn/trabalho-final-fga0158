package main;

public class Motorista extends Usuario{
//	private boolean cnhValida;
	private StatusMotorista status;
	Veiculo veiculo;
	
	public boolean aceitarCorrida(Corrida corrida) {
		if (this.status == StatusMotorista.Online) {
			corrida.setMotorista(this);
			return true;
		}
		System.out.println("O motorista " + this.getNome() + " nao esta disponivel.");
		return false;
	}
	public Motorista(String nome, String cpf, String email, String telefone, String senha) {
		super(nome, cpf, email, telefone, senha);
	}
	public Motorista(String nome) {
		super(nome);
	}
}
