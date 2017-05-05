package br.jus.tre_pa.sdu.spring.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "MOVIMENTACAO")
public class Movimentacao implements Serializable {

	private static final long serialVersionUID = 1L;



	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MOVIMENTACAO")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "SEQ_MOVIMENTACAO", sequenceName = "SEQ_MOVIMENTACAO")
	private Long id;

	/**
	 * 
	 */
	private String codMovimentacao;
	
	
	@OneToMany(mappedBy = "movimentacao", cascade = {CascadeType.ALL}, orphanRemoval=true)
	@BatchSize(size = 20)
	//@LazyCollection(LazyCollectionOption.EXTRA)
	private List<ItemMovimentacao> itensMovimentacao;

	/**
	 * 
	 */
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dtMovimentacao;


	/**
	 * 
	 */
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dtConfirmacaoRecebimento;

	/**
	 * 
	 */
	@Column(length = 1024)
	private String observacao;
	
	@ManyToOne
	private Local localDestino;

	/**
	 * 
	 */
	@ManyToOne
	private Local localOrigem;



	public Movimentacao() {
		super();
	}

	public Movimentacao(Long id, Date dtMovimentacao, String observacao) {
		super();
		this.id = id;
		this.dtMovimentacao = dtMovimentacao;
		this.observacao = observacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodMovimentacao() {
		return codMovimentacao;
	}

	public void setCodMovimentacao(String codMovimentacao) {
		this.codMovimentacao = codMovimentacao;
	}

	public Date getDtMovimentacao() {
		return dtMovimentacao;
	}

	public void setDtMovimentacao(Date dtMovimentacao) {
		this.dtMovimentacao = dtMovimentacao;
	}

	public Date getDtConfirmacaoRecebimento() {
		return dtConfirmacaoRecebimento;
	}

	public void setDtConfirmacaoRecebimento(Date dtConfirmacaoRecebimento) {
		this.dtConfirmacaoRecebimento = dtConfirmacaoRecebimento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
	

	public List<ItemMovimentacao> getItensMovimentacao() {
		return itensMovimentacao;
	}

	public void setItensMovimentacao(List<ItemMovimentacao> itensMovimentacao) {
		this.itensMovimentacao = itensMovimentacao;
	}

	public Local getLocalDestino() {
		return localDestino;
	}

	public void setLocalDestino(Local localDestino) {
		this.localDestino = localDestino;
	}

	public Local getLocalOrigem() {
		return localOrigem;
	}

	public void setLocalOrigem(Local localOrigem) {
		this.localOrigem = localOrigem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codMovimentacao == null) ? 0 : codMovimentacao.hashCode());
		result = prime * result + ((dtConfirmacaoRecebimento == null) ? 0 : dtConfirmacaoRecebimento.hashCode());
		result = prime * result + ((dtMovimentacao == null) ? 0 : dtMovimentacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
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
		Movimentacao other = (Movimentacao) obj;
		if (codMovimentacao == null) {
			if (other.codMovimentacao != null)
				return false;
		} else if (!codMovimentacao.equals(other.codMovimentacao))
			return false;
		if (dtConfirmacaoRecebimento == null) {
			if (other.dtConfirmacaoRecebimento != null)
				return false;
		} else if (!dtConfirmacaoRecebimento.equals(other.dtConfirmacaoRecebimento))
			return false;
		if (dtMovimentacao == null) {
			if (other.dtMovimentacao != null)
				return false;
		} else if (!dtMovimentacao.equals(other.dtMovimentacao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movimentacao [id=" + id + ", codMovimentacao=" + codMovimentacao + ", dtMovimentacao=" + dtMovimentacao
				+ ", dtConfirmacaoRecebimento=" + dtConfirmacaoRecebimento + ", observacao=" + observacao + "]";
	}
	
	
	
	
	
}
