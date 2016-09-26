package vraptor_suporten2.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="SuporteN2_Atendimento")
public class Atendimento {

	@Id
	@GeneratedValue
	private Integer id; 
	
	@ManyToOne
	@NotNull(message="N�o pode ser nulo")
	private Solucao solucao;
	
	@NotEmpty(message="Campo obrigat�rio")
	private String loginOperador;
	
	@NotEmpty(message="Campo obrigat�rio")
	private String loginRegistro;
	
	@NotEmpty(message="Campo obrigat�rio")
	private String terminal;	
	
	@Lob
	private String observacao;
	
	private Date dataRegistro;
	
	public Atendimento() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Solucao getSolucao() {
		return solucao;
	}

	public void setSolucao(Solucao solucao) {
		this.solucao = solucao;
	}

	public String getLoginOperador() {
		return loginOperador;
	}

	public void setLoginOperador(String loginOperador) {
		this.loginOperador = loginOperador;
	}

	public String getLoginRegistro() {
		return loginRegistro;
	}

	public void setLoginRegistro(String loginRegistro) {
		this.loginRegistro = loginRegistro;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
}
