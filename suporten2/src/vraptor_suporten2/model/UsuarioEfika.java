package vraptor_suporten2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="SUPORTEN2_USUARIOS")
public class UsuarioEfika {
	
	@Id
	@NotEmpty
	private String login;
		
	private Boolean adm;
	
	private Boolean ativo;
	
	public UsuarioEfika() {
	}

	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}	
	
	public Boolean getAdm() {
		return adm;
	}

	public void setAdm(Boolean adm) {
		this.adm = adm;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
