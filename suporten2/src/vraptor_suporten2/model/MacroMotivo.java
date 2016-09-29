package vraptor_suporten2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="SuporteN2_MacroMotivo")
public class MacroMotivo {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty(message="Campo requerido!")
	private String nome;
	
	private Boolean ativo = false;
	
	@ManyToOne
	@NotNull
	private Rede rede;
	
	public MacroMotivo() {
		rede = new Rede();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Rede getRede() {
		return rede;
	}

	public void setRede(Rede rede) {
		this.rede = rede;
	}
}
