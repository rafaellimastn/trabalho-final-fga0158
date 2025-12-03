package servicos;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import entidades.*;

public class GerenciadorUsuario {
	
	private List<Usuario> listaDeUsuarios = new ArrayList<>();
	private List<Motorista> listaDeMotoristas = new ArrayList<>();
	
	public void CadastrarPassageiro(String nome, String cpf, String email, String telefone, String senha) {
		Passageiro NovoPassageiro = new Passageiro(nome, cpf, email, telefone, senha);
		listaDeUsuarios.add(NovoPassageiro);
		}
		
	public void CadastrarMotorista(String nome, String cpf, String email, String telefone, String senha, String modelo, String cor, String ano, String placa, String numero, LocalDate data) {
		Motorista novoMotorista = new Motorista(nome, cpf, email, telefone, senha);
		novoMotorista.comprarCarro(placa, modelo, cor, ano);
		novoMotorista.tirarCNH(numero, data);
		listaDeMotoristas.add(novoMotorista);
		listaDeUsuarios.add(novoMotorista);
		}

	public List<Usuario> getListaDeUsuarios() {
		return listaDeUsuarios;
	}

	public void setListaDeUsuarios(List<Usuario> listaDeUsuarios) {
		this.listaDeUsuarios = listaDeUsuarios;
	}

	public List<Motorista> getListaDeMotoristas() {
		return listaDeMotoristas;
	}

	public void setListaDeMotoristas(List<Motorista> listaDeMotoristas) {
		this.listaDeMotoristas = listaDeMotoristas;
	}
}
