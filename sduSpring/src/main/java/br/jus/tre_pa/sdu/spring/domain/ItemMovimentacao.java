package br.jus.tre_pa.sdu.spring.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ITEM_MOVIMENTACAO")
public class ItemMovimentacao implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ITEM_MOVIMENTACAO")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "SEQ_ITEM_MOVIMENTACAO", sequenceName = "SEQ_ITEM_MOVIMENTACAO")
	private Long id;

	/**
	 * Quantidade de materiais na entrada.
	 */
	@Column
	private Integer qtdEmUnidades;

	/**
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "MATERIAL_ID")
	//@JsonIgnore
	private Material material;



	
	
	public ItemMovimentacao() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQtdEmUnidades() {
		return qtdEmUnidades;
	}

	public void setQtdEmUnidades(Integer qtdEmUnidades) {
		this.qtdEmUnidades = qtdEmUnidades;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemMovimentacao other = (ItemMovimentacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemMovimentacaoEditMB [id=" + id + ", qtdEmUnidades=" + qtdEmUnidades + ", material=" + material + "]";
	}

}// end ItemEntradaMaterialEditMB