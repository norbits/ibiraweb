package ibiraweb.portal.rodape;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class RodapeBean {

	
	private String nomeUsuario = "Adamastor de Oliveira e Prado";
	private String direitosReservados;
	private String endereco;
	private String desenvolvidoPor;
	private String desenvolvidoTelefone;
	
	
	
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getDireitosReservados() {
		return direitosReservados;
	}
	public void setDireitosReservados(String direitosReservados) {
		this.direitosReservados = direitosReservados;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getDesenvolvidoPor() {
		return desenvolvidoPor;
	}
	public void setDesenvolvidoPor(String desenvolvidoPor) {
		this.desenvolvidoPor = desenvolvidoPor;
	}
	public String getDesenvolvidoTelefone() {
		return desenvolvidoTelefone;
	}
	public void setDesenvolvidoTelefone(String desenvolvidoTelefone) {
		this.desenvolvidoTelefone = desenvolvidoTelefone;
	}
	
	
	
	
	
	
	
}
