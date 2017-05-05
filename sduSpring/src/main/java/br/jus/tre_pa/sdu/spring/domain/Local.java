package br.jus.tre_pa.sdu.spring.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LOCAL")
public class Local implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public enum LocalType {

		ZONA_CAPITAL ("ZONA_CAPITAL") ,
		ZONA_INTERIOR ("ZONA_INTERIOR") ,
		DEPOSITO_URNAS ("DEPOSITO_URNAS") ,
		TSE ("TSE"),
		TRE ("TRE"),
		EXTERNO ("EXTERNO");
	
		private String type;
		
		private LocalType(String type) {
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LOCAL")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "SEQ_LOCAL", sequenceName = "SEQ_LOCAL")
	private Long id;

	/**
	 * 
	 */
	@Column(nullable = false, unique = true)
		private String nome;

	/**
	 * 
	 */
	@Column
	private String endereco;

	/**
	 * 
	 */
	@Column
	private String telefone;

	/**
	 * 
	 */
	@Column(length = 64)
	private String email;
	
	/**
	 * 
	 */
	@Column(name="NUM_ZONA")
	private Integer numeroZona;
	

	
	
	@Enumerated(EnumType.STRING)
	private LocalType localType;

	public Local() {
		super();
	}

	public Local(String nome) {
		super();
		this.nome = nome;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNumeroZona() {
		return numeroZona;
	}

	public void setNumeroZona(Integer numeroZona) {
		this.numeroZona = numeroZona;
	}

	public LocalType getLocalType() {
		return localType;
	}

	public void setLocalType(LocalType localType) {
		this.localType = localType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((localType == null) ? 0 : localType.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroZona == null) ? 0 : numeroZona.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Local other = (Local) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (localType != other.localType)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroZona == null) {
			if (other.numeroZona != null)
				return false;
		} else if (!numeroZona.equals(other.numeroZona))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Local [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", email="
				+ email + ", numeroZona=" + numeroZona + ", localType=" + localType + "]";
	}
	
	
	
	
	
}
