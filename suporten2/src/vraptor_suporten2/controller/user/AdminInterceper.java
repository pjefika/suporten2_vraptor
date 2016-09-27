package vraptor_suporten2.controller.user;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import vraptor_suporten2.controller.UsuarioController;
import vraptor_suporten2.model.annotation.Admin;

@Intercepts
@RequestScoped
@AcceptsWithAnnotations(Admin.class)
public class AdminInterceper {

	@Inject
	private Result result;
	
	private SessionUsuarioEfika session;
	
	public AdminInterceper() {

	}

	@BeforeCall
	public void before() {
		if(session == null || !session.isAdmin()){
			result.redirectTo(UsuarioController.class).restrito();
		}
	}
}
