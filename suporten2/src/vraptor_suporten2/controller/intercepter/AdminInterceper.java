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
import vraptor_suporten2.model.annotation.Admin;


@Intercepts
@RequestScoped
@AcceptsWithAnnotations(Admin.class)
@Named
public class AdminInterceper {

	private Result result;

	private SessionUsuarioEfika session;
	

    /**
     * @deprecated CDI eyes only
     */
    protected AdminInterceper() {
    	
    }
    
    @Inject
    public AdminInterceper(SessionUsuarioEfika session){
    	this.session = session;
    }

	@BeforeCall
	public void before() {
		
		try {			
			if(session == null || !session.isAdmin()){
				result.redirectTo(UsuarioController.class).restrito();
			}
		} catch (Exception e) {
			result.redirectTo(UsuarioController.class).restrito();
			
		}
	}

	
}
