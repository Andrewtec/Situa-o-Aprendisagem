package projeto.mb;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import projeto.dao.UsuarioDao;
import projeto.entity.Usuario;

@SessionScoped
@ManagedBean
public class SessaoUsuarioMb {
	private Usuario usuarioLogado;

	private Usuario usuarioLogin;

	@PostConstruct
	public void init() {
		usuarioLogin = new Usuario();
	}

	public String getNomeUsuario() {
		return usuarioLogado.getNome();
	}

	public boolean isLogado() {
		return usuarioLogado != null;
	}

	public String login() {
		if (fazerLogin()) {
			return "index?faces-redirect=true";
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Usuário ou senha não confere."));
		return "";
	}

	private boolean fazerLogin() {
		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = dao.buscarUsuarioPorNome(usuarioLogin.getNome());

		if (usuario == null)
			return false;
		if (!usuario.getSenha().equals(usuarioLogin.getSenha()))
			return false;
		if (!usuario.getNome().equalsIgnoreCase(usuarioLogin.getNome()))
			return false;

		usuarioLogado = usuario;
		return true;
	}

	public String logout() {
		usuarioLogado = null;
		return "index?faces-redirect=true";
	}

	public Usuario getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(Usuario usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}
}
