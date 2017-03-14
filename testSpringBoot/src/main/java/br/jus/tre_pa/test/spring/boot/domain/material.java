package br.jus.tre_pa.test.spring.boot.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MATERIAL")
@Inheritance(strategy = InheritanceType.JOINED)
public class material implements Serializable	{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MATERIAL")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "SEQ_MATERIAL", sequenceName = "SEQ_MATERIAL")
	private Long id;

	/**
	 * 
	 */
	@Column
	private String nome;

	/**
	 * 
	 */
	@Column
	private BigDecimal peso;

	/**
	 * 
	 */
	@Column
	private BigDecimal valorUnitario;

	/**
	 * 
	 */
	@Column
	private String descricao;

	/**
	 * 
	 */
	@Column
	private Integer ordemRelevancia;




}
