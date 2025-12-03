package Entidades;

public class Motorista extends Usuario{

    private CNH cnh;
    private StatusMotorista status;
    private Veiculo veiculo;

    public void iniciarCorrida(Corrida corrida) {
        if (corrida == null) throw new IllegalArgumentException("Corrida nula.");
        if (this.status != StatusMotorista.Online) throw new IllegalStateException("Motorista não está online.");
        if (corrida.getMotorista() == null) {
            corrida.setMotorista(this);
        }
        corrida.setStatus(StatusCorrida.EmAndamento);
        System.out.println("Corrida " + corrida.getStatus() );
    }

    public void finalizarCorrida(Corrida corrida) {
        if (corrida == null) throw new IllegalArgumentException("Corrida nula.");
        corrida.setStatus(StatusCorrida.Finalizada);
        System.out.println("Corrida " + corrida.getStatus() );
    }

    public boolean cancelarCorrida(Corrida corrida) {
        if (corrida == null) return false;
        corrida.setStatus(StatusCorrida.Cancelada);
        return true;
    }

    public boolean aceitarCorrida(Corrida corrida) {
        if (this.status == StatusMotorista.Online) {
            corrida.setMotorista(this);
            corrida.setStatus(StatusCorrida.Aceita);
            return true;
        } else {
            System.out.println("O motorista " + this.getNome() + " nao esta disponivel.");
            return false;
        }
    }

    public void serAvaliado(Passageiro passageiro, Corrida corrida, int nota, String comentario) {
        if (corrida == null) throw new IllegalArgumentException("Corrida nula.");
        if (!corrida.getPassageiro().equals(passageiro)) {
            throw new IllegalArgumentException("Somente o passageiro da corrida pode avaliar o motorista.");
        }
        if (!corrida.getMotorista().equals(this)) {
            throw new IllegalArgumentException("Esta corrida não pertence a este motorista.");
        }
        if (corrida.getStatus() != StatusCorrida.Finalizada) {
            throw new IllegalStateException("Corrida deve estar finalizada para ser avaliada.");
        }

        Avaliacao avaliacao = new Avaliacao(passageiro, this, corrida, nota, comentario);
        this.receberAvaliacao(avaliacao);
    }

    public Motorista(String nome, String cpf, String email, String telefone, String senha, Veiculo veiculo, CNH cnh) {
        super(nome, cpf, email, telefone, senha);
        setVeiculo(veiculo);
        setCnh(cnh);
        setStatus(StatusMotorista.Offline);
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
}
