package br.jus.tre_pa.sdu.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import br.jus.tre_pa.sdu.spring.domain.Movimentacao;
import br.jus.tre_pa.sdu.spring.repository.MovimentacaoRepository;
import java.util.List;
import br.jus.tre_pa.sdu.spring.domain.ItemMovimentacao;
import br.jus.tre_pa.sdu.spring.repository.ItemMovimentacaoRepository;	

@Service
public class MovimentacaoService {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	@Autowired
	private ItemMovimentacaoRepository itemMovimentacaoRepository;	

	
	/**
	 * Retorna uma lista de  Movimentacao com paginação. 
	 *
	 * @param pageable 
	 * @return 
	 */
	public Page<Movimentacao> findAll(Pageable pageable) {
		return movimentacaoRepository.findAll(pageable);
	}

	/**
	 * Retorna um lista de ItemMovimentacao.
	 *
	 * @param id Id de Movimentacao.
	 * @return
	 */
	public List<ItemMovimentacao> findItensMovimentacao(Long id) {
		return movimentacaoRepository.findItensMovimentacao(id);
	}

	/**
	 * Retorna uma instância de  Movimentacao pelo id. 
	 *
	 */
	public Movimentacao findOne(Long id) {
		return movimentacaoRepository.findOne(id);
	}

	/**
	 * Verifica se a instância de Movimentacao existe na base de dados.
	 *
	 * @param id Id de Movimentacao.
	 * @return
	 */
	public boolean exists(Long id) {
		return movimentacaoRepository.exists(id);
	}

	/**
	 * Deleta uma instância de Movimentacao.
	 * 
	 * @param id Id do objeto a ser deletado.
	 */
	@Transactional
	public void delete(Long id) {
		movimentacaoRepository.delete(id);
	}
	
	/**
	 * Insere uma instância de Movimentacao na base de dados. 
	 *
	 * @param newFoo Objeto com os dados para inserção de Movimentacao.
	 * @return Movimentacao atualizado.
	 */
	@Transactional
	public Movimentacao insert(Movimentacao newMovimentacao) {
		Movimentacao movimentacao = new Movimentacao();
		this.updateAttributes(movimentacao, newMovimentacao);
		return movimentacaoRepository.save(movimentacao);
	}
	
	/**
	 * Atualiza a instância de Movimentacao na base de dados. 
	 *
	 * @param newFoo Objeto com os dados para atualização de Movimentacao.
	 * @return Movimentacao atualizado.
	 */
	@Transactional
	public Movimentacao update(Movimentacao newMovimentacao) {
		Movimentacao movimentacao = movimentacaoRepository.findOne(newMovimentacao.getId());
		this.updateAttributes(movimentacao, newMovimentacao);
		return movimentacaoRepository.save(movimentacao);
	}

	private void updateAttributes(Movimentacao movimentacao, Movimentacao newMovimentacao) {
		movimentacao.setObservacao(newMovimentacao.getObservacao());
		movimentacao.setCodMovimentacao(newMovimentacao.getCodMovimentacao());
		movimentacao.setDtMovimentacao(newMovimentacao.getDtMovimentacao());
		movimentacao.setDtConfirmacaoRecebimento(newMovimentacao.getDtConfirmacaoRecebimento());
	}

}
