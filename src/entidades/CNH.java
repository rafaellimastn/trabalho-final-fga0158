package entidades;
import java.time.LocalDate;
public class CNH {

	private String numero;
    private LocalDate dataVencimento; // LocalDate é ideal para datas como vencimento

    // Construtor
    public CNH(String numero, LocalDate dataVencimento) {
        this.numero = numero;
        this.dataVencimento = dataVencimento;
    }

    // Getters
    public String getNumero() {
        return numero;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    // Setters (apenas se for necessário atualizar, como a renovação da CNH)
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    // Método de utilidade para checar a validade
    public boolean estaValida() {
        return dataVencimento.isAfter(LocalDate.now());
    }
}
