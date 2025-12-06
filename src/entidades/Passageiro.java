package entidades;

import java.util.ArrayList;

import java.util.List;

import servicos.GerenciadorDeCorridas;

public class Passageiro extends Usuario {

    private boolean pendenciaFinanceira;
    private List<MetodoDePagamento> metodosDePagamento = new ArrayList<>();

    public Passageiro(String nome, String cpf, String email, String telefone, String senha) {
        super(nome, cpf, email, telefone, senha);
    }
    
    public Passageiro() {}

    public void adicionarMetodoPagamento(MetodoDePagamento metodo) {
        if (metodo != null) metodosDePagamento.add(metodo);
    }

    public MetodoDePagamento obterMetodoPadrao() {
        if (metodosDePagamento.isEmpty()) return null;
        return metodosDePagamento.get(0);
    }

    // public void serAvaliado(Motorista avaliador, int nota, String comentario, Corrida corrida) {z
    // Avaliacao avaliacao = new Avaliacao(avaliador, this, corrida, nota, comentario);
    // this.receberAvaliacao(avaliacao);
    // }

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

	public Passageiro(GerenciadorDeCorridas gerenciadorCorridas) {
		super(gerenciadorCorridas);
		// TODO Auto-generated constructor stub
	}
}
