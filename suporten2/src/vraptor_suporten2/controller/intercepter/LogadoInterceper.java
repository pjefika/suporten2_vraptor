package vraptor_suporten2.controller.intercepter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import vraptor_suporten2.controller.UsuarioController;
import vraptor_suporten2.controller.user.SessionUsuarioEfika;
import vraptor_suporten2.model.annotation.Logado;


@Intercepts
@RequestScoped
@AcceptsWithAnnotations(Logado.class)
@Named
public class LogadoInterceper {

	@Inject
	private Result result;

	@Inject
	private SessionUsuarioEfika session;

    /**
     * @deprecated CDI eyes only
     */
    protected LogadoInterceper() {
    	
    }
    
    @Inject
    public LogadoInterceper(SessionUsuarioEfika session){
    	this.session = session;
    }

	@BeforeCall
	public void before() {
		
		try {			
			if(session == null){
				result.redirectTo(UsuarioController.class).restrito();
			}
		} catch (Exception e) {
			result.redirectTo(UsuarioController.class).restrito();
			
		}
	}

	
}
