package vraptor_suporten2.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="SuporteN2_Motivo")
public class Motivo implements EntityCrudInterface{
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty(message="Campo requerido!")
	private String nome;
	
	private Boolean ativo = false;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@NotNull
	private MacroMotivo macroMotivo;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="motivo", cascade=CascadeType.REFRESH)
	private List<Solucao> solucaos;

	public Motivo() {
		macroMotivo = new MacroMotivo();
	}
	
	public Motivo(Integer id) {
		this.id = id;
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

	public MacroMotivo getMacroMotivo() {
		return macroMotivo;
	}
	
	public List<Solucao> getSolucaoAtivos() {
		
		List<Solucao> lista = new ArrayList<Solucao>();
				
		for (Solucao solucao : this.solucaos) {
			if(solucao.getAtivo()){
				lista.add(solucao);
			}
		}
		
		return lista;
	}

	public void setMacroMotivo(MacroMotivo macroMotivo) {
		this.macroMotivo = macroMotivo;
	}

}
