package vraptor_suporten2.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="SUPORTEN2_REDE")
public class Rede implements EntityCrudInterface{
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty(message="Campo obrigat�rio!")
	private String nome;
	
	private Boolean ativo;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="rede", cascade=CascadeType.REFRESH)
	private List<MacroMotivo> macroMotivos;

	public Rede() {
	}
	
	public Rede(Integer id) {
		this.id = id;
	}
	
	public Rede(String nome) {
		this.nome = nome;
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
	
	public List<MacroMotivo> getMacroMotivos() {
		return macroMotivos;
	}

	public void setMacroMotivos(List<MacroMotivo> macroMotivos) {
		this.macroMotivos = macroMotivos;
	}
}
