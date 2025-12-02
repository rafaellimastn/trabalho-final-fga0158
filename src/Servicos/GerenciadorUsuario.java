package servicos;

import java.util.ArrayList;
import java.util.List;

import entidades.*;

public class GerenciadorUsuario {
	
	private List<Usuario> listaDeUsuarios = new ArrayList<>();
	private List<Motorista> listaDeMotoristas = new ArrayList<>();
	
	public void CadastrarPassageiro(String nome, String cpf, String email, String telefone, String senha) {
		Passageiro NovoPassageiro = new Passageiro(nome, cpf, email, telefone, senha);
		listaDeUsuarios.add(NovoPassageiro);
		}
		
		
		
	public void CadastrarMotorista(String nome, String cpf, String email, String telefone, String senha) {
		Motorista novoMotorista = new Motorista(nome, cpf, email, telefone, senha);
		listaDeMotoristas.add(novoMotorista);
		listaDeUsuarios.add(novoMotorista);
		}

		
}
