package vraptor_suporten2.controller;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.view.Results;
import vraptor_suporten2.controller.user.SessionUsuarioEfika;
import vraptor_suporten2.model.annotation.Admin;

@Intercepts
@RequestScoped
@AcceptsWithAnnotations(Admin.class)
public class Log {

	@Inject
	private SessionUsuarioEfika session;

	@Inject
	private Result result;

	public Log() {
		session = new SessionUsuarioEfika();
	}

	@BeforeCall
	public void before() {
		result.use(Results.logic()).redirectTo(UsuarioController.class).form();
	}

}