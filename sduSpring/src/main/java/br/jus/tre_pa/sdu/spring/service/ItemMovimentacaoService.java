package br.jus.tre_pa.sdu.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import br.jus.tre_pa.sdu.spring.domain.ItemMovimentacao;
import br.jus.tre_pa.sdu.spring.repository.ItemMovimentacaoRepository;
import java.util.List;

@Service
public class ItemMovimentacaoService {

	@Autowired
	private ItemMovimentacaoRepository itemMovimentacaoRepository;


	public Page<ItemMovimentacao> findAll(Pageable pageable) {
		return itemMovimentacaoRepository.findAll(pageable);
	}


	public ItemMovimentacao findOne(Long id) {
		return itemMovimentacaoRepository.findOne(id);
	}

	public boolean exists(Long id) {
		return itemMovimentacaoRepository.exists(id);
	}

	@Transactional
	public void delete(Long id) {
		itemMovimentacaoRepository.delete(id);
	}
	
	@Transactional
	public ItemMovimentacao insert(ItemMovimentacao newItemMovimentacao) {
		ItemMovimentacao itemMovimentacao = new ItemMovimentacao();
		this.updateAttributes(itemMovimentacao, newItemMovimentacao);
		return itemMovimentacaoRepository.save(itemMovimentacao);
	}
	
	@Transactional
	public ItemMovimentacao update(ItemMovimentacao newItemMovimentacao) {
		ItemMovimentacao itemMovimentacao = itemMovimentacaoRepository.findOne(newItemMovimentacao.getId());
		this.updateAttributes(itemMovimentacao, newItemMovimentacao);
		return itemMovimentacaoRepository.save(itemMovimentacao);
	}

	private void updateAttributes(ItemMovimentacao itemMovimentacao, ItemMovimentacao newItemMovimentacao) {
		itemMovimentacao.setQtdEmUnidades(newItemMovimentacao.getQtdEmUnidades());
	}

}
