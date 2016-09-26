package vraptor_suporten2.controller.user;

import java.io.Serializable;
import javax.faces.bean.SessionScoped;

import webservices.Usuario;

@SessionScoped
public class SessionUsuarioEfika implements Serializable {

	private static final long serialVersionUID = -2203745431602457513L;

	private Usuario usuario;
	
	public SessionUsuarioEfika() {

	}
	
	public SessionUsuarioEfika(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
