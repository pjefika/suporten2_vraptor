package vraptor_suporten2.controller.user;

import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import vraptor_suporten2.model.UsuarioEfika;

@SessionScoped
public class SessionUsuarioEfika implements Serializable {

	private static final long serialVersionUID = -2203745431602457513L;

	private UsuarioEfika user;
 
	public SessionUsuarioEfika() {
		user = new UsuarioEfika();
	}
	
	public boolean logado(){
		return user.getLogin().isEmpty();
	}
}
