package projeto.mb;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import projeto.util.JpaUtil;


@ManagedBean
public class ContatoMb {
	private String nome;
	private String email;
	private String telefone;
	private String assunto;
	private String mensagem;
	
	
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
		}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public void enviar(){
		EntityManager entityManager = JpaUtil.getEntityManager();
		
		System.out.println("Nome: " + nome);
		System.out.println("Email: " + email);
		System.out.println("Telefone: " + telefone);
		System.out.println("Assunto:  " + assunto);
		System.out.println("Mensagem: " + mensagem);
		
	}
}
