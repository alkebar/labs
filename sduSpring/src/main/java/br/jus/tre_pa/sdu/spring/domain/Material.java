package br.jus.tre_pa.sdu.spring.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlEnum;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "MATERIAL")
public class Material implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlEnum
	public enum MaterialType {

		PERMANENTE("PERMANENTE"),

		SUPRIMENTO("SUPRIMENTO"),

		PECA_REPOSICAO("PECA_REPOSICAO");

		private String type;

		private MaterialType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}

	}

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MATERIAL")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "SEQ_MATERIAL", sequenceName = "SEQ_MATERIAL")
	private Long id;

	/**
	 * 
	 */
	@Column(nullable = false)
	private String nome;

	/**
	 * 
	 */
	@Column
	private BigDecimal peso;

	/**
	 * 
	 */
	@Column//(name = "VALORUNITARIO")
	private BigDecimal valorUnitario;

	/**
	 * 
	 */
	@Column
	private String descricao;

	/**
	 * 
	 */
	@Column//(name="ORDEMRELEVANCIA")
	private Integer ordemRelevancia;



	/**
	 * 
	 */
	@OneToMany(mappedBy = "material")
	@BatchSize(size = 15)
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<ItemMovimentacao> itemMovimentacao;

	/**
	 * 
	 */
	@Enumerated(EnumType.STRING)
	private MaterialType materialType;

	public Material() {
		super();
	}
	
	
	
	

	public Material(Long id, String nome, BigDecimal peso, BigDecimal valorUnitario, String descricao,
			Integer ordemRelevancia, List<ItemMovimentacao> itemMovimentacao, MaterialType materialType) {
		super();
		this.id = id;
		this.nome = nome;
		this.peso = peso;
		this.valorUnitario = valorUnitario;
		this.descricao = descricao;
		this.ordemRelevancia = ordemRelevancia;
		this.itemMovimentacao = itemMovimentacao;
		this.materialType = materialType;
	}





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getOrdemRelevancia() {
		return ordemRelevancia;
	}

	public void setOrdemRelevancia(Integer ordemRelevancia) {
		this.ordemRelevancia = ordemRelevancia;
	}




	@JsonIgnore
	public List<ItemMovimentacao> getItemMovimentacao() {
		return itemMovimentacao;
	}

	public void setItemMovimentacao(List<ItemMovimentacao> itemMovimentacao) {
		this.itemMovimentacao = itemMovimentacao;
	}

	public MaterialType getMaterialType() {
		return materialType;
	}

	public void setMaterialType(MaterialType materialType) {
		this.materialType = materialType;
	}
	
	/*public MaterialType[] getMaterialTypeArray(){
		return MaterialType.values();
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Material other = (Material) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Material [id=" + id + ", nome=" + nome + ", peso=" + peso + ", valorUnitario=" + valorUnitario
				+ ", descricao=" + descricao + ", ordemRelevancia=" + ordemRelevancia + ", materialType=" + materialType
				+ "]";
	}

}