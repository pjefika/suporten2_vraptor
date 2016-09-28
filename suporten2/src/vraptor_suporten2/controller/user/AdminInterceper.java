package vraptor_suporten2.controller.user;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import vraptor_suporten2.controller.UsuarioController;
import vraptor_suporten2.model.annotation.Admin;


@Intercepts
@RequestScoped
@AcceptsWithAnnotations(Admin.class)
@Named
public class AdminInterceper {

	@Inject
	private Result result;

	@Inject
	private SessionUsuarioEfika session;

	@BeforeCall
	public void before() {
		
		try {
			
			System.out.println(session.getUsuario().getLogin());
			
			if(session == null || !session.isAdmin()){
				result.redirectTo(UsuarioController.class).restrito();
			}
		} catch (Exception e) {
			result.redirectTo(UsuarioController.class).restrito();
			
		}
	}

	
}
