package servicos;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorUsuario {
	
	private List<Usuario> ListaDeUsuarios = new ArrayList<>();
	private List<Motorista> ListaDeMotoristas = new ArrayList<>();
	
	public void CadastrarPassageiro(String Nome, String CPF, String Email, String Senha, String Telefone, String TipoUsuario ) {
		Passageiro NovoPassageiro = new Passageiro();
		NovoPassageiro.setNome(Nome);
		NovoPassageiro.setCPF(CPF);
		NovoPassageiro.setEmail(Email);
		NovoPassageiro.setSenha(Senha);
		NovoPassageiro.setTelefone(Telefone);
		NovoPassageiro.setTipoUsuario(TipoUsuario);
		ListaDeUsuarios.add(NovoPassageiro);};
		
		
		
		public void CadastrarMotorista(String Nome, String CPF, String Email, String Senha, String Telefone, String TipoUsuario ) {
			Motorista NovoMotorista = new Motorista();
			NovoMotorista.setNome(Nome);
			NovoMotorista.setCPF(CPF);
			NovoMotorista.setEmail(Email);
			NovoMotorista.setSenha(Senha);
			NovoMotorista.setTelefone(Telefone);
			NovoMotorista.setTipoUsuario(TipoUsuario);
			ListaDeUsuarios.add(NovoMotorista);
			ListaDeMotoristas.add(NovoMotorista);};

		
}
