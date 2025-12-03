package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Passageiro extends Usuario {

    private boolean pendenciaFinanceira;
    private List<MetodoDePagamento> metodosDePagamento = new ArrayList<>();

    public Passageiro(String nome, String cpf, String email, String telefone, String senha) {
        super(nome, cpf, email, telefone, senha);
    }

    public void adicionarMetodoPagamento(MetodoDePagamento metodo) {
        if (metodo != null) metodosDePagamento.add(metodo);
    }

    public MetodoDePagamento obterMetodoPadrao() {
        if (metodosDePagamento.isEmpty()) return null;
        return metodosDePagamento.get(0);
    }

    public Corrida solicitarCorrida(String origem, String destino, double distancia, CategoriaServico categoria) {
        if (pendenciaFinanceira == true) {System.out.println("Pague a pendência para solicitar uma corrida");}
    	String id = UUID.randomUUID().toString();
        Corrida c = new Corrida(id, origem, destino, distancia, this, categoria);
        return c;
    }

    public void serAvaliado(Motorista avaliador, int nota, String comentario, Corrida corrida) {
        Avaliacao avaliacao = new Avaliacao(avaliador, this, corrida, nota, comentario);
        this.receberAvaliacao(avaliacao);
    }

	public boolean isPendenciaFinanceira() {
		return pendenciaFinanceira;
	}

	public void setPendenciaFinanceira(boolean pendenciaFinanceira) {
		this.pendenciaFinanceira = pendenciaFinanceira;
	}

	public List<MetodoDePagamento> getMetodosDePagamento() {
		return metodosDePagamento;
	}

	public void setMetodosDePagamento(List<MetodoDePagamento> metodosDePagamento) {
		this.metodosDePagamento = metodosDePagamento;
	}
}
