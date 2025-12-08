package servicos;

import java.util.List;
import java.util.ArrayList;
import entidades.*;

public class GerenciadorUsuario {
	
	private List<Usuario> listaDeUsuarios = new ArrayList<>();
	private List<Motorista> listaDeMotoristas = new ArrayList<>();
	
	protected Motorista selecionarMotorista() {
		for (Motorista m : listaDeMotoristas) {
			if (m.getStatus() == StatusMotorista.Online) {
				return m;
			}
		}
		System.out.println("Nenhum motorista disponível.");
		return null;
	}
	public void CadastrarPassageiro(Passageiro passageiro) {
		listaDeUsuarios.add(passageiro);
		}
		
	public void CadastrarMotorista(Motorista motorista) {
		listaDeMotoristas.add(motorista);
		listaDeUsuarios.add(motorista);
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
