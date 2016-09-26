package vraptor_suporten2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="SUPORTEN2_REDE")
public class Rede {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty(message="Campo obrigatório!")
	private String nome;
	
	private Boolean ativo = true;
	
	public Rede() {

	}
	
	public Rede(String nome) {

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
	
	

}
