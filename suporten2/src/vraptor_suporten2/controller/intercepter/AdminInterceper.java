package vraptor_suporten2.controller.intercepter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import vraptor_suporten2.controller.UsuarioController;
import vraptor_suporten2.controller.user.SessionUsuarioEfika;
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
	

    /**
     * @deprecated CDI eyes only
     */
    protected AdminInterceper() {
    	
    }
    
    @Inject
    public AdminInterceper(SessionUsuarioEfika session){
    	this.session = session;
    }

    @AroundCall
	public void around(SimpleInterceptorStack stack){
    	
    	try {
        	if(session.getUsuario().getNivel() > 7){
        		stack.next();
        	}else{
            	result.forwardTo(UsuarioController.class).restrito();
        	}
		} catch (Exception e) {
			result.forwardTo(UsuarioController.class).restrito();
		}


	}

	
}
