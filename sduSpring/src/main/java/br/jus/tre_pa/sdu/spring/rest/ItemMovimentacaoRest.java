package br.jus.tre_pa.sdu.spring.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import br.jus.tre_pa.sdu.spring.domain.ItemMovimentacao;
import br.jus.tre_pa.sdu.spring.service.ItemMovimentacaoService;

@RestController
public class ItemMovimentacaoRest {

	private Logger log = LoggerFactory.getLogger(ItemMovimentacaoRest.class);

	@Autowired
	private ItemMovimentacaoService itemMovimentacaoService;

	/**
	 * Endpoint para buscar todas as instâncias de ItemMovimentacao.
	 *
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/api/itemMovimentacaos")
	public ResponseEntity<?> findAll(Pageable pageable) {
		log.debug("[findAll] Requisição para buscar todos itemMovimentacaos");
		Page<ItemMovimentacao> itemMovimentacaos = itemMovimentacaoService.findAll(pageable);
		return ResponseEntity.ok(itemMovimentacaos);
	}


	/**
	 * Endpoint para buscar 1 (uma) instância de ItemMovimentacao.
	 *
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/api/itemMovimentacaos/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Long id) {
		log.debug("[find] Requisição para buscar itemMovimentacao. id={}", id);
		boolean exists = itemMovimentacaoService.exists(id);
		if (exists) {
			log.debug("[find] itemMovimentacao encontrado.");
			return ResponseEntity.ok(itemMovimentacaoService.findOne(id));
		}
		log.debug("[find] itemMovimentacao NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

	/**
	 * Endpoint para deleção de ItemMovimentacao.
	 *
	 */
	@RequestMapping(method = RequestMethod.DELETE, path = "/api/itemMovimentacaos/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		log.debug("[delete] Requisição para deletar itemMovimentacao. id={}", id);
		boolean exists = itemMovimentacaoService.exists(id);
		if (exists) {
			log.debug("[delete] itemMovimentacao encontrado.");
			itemMovimentacaoService.delete(id);
			log.debug("[delete] itemMovimentacao deletado com sucesso.");
			return ResponseEntity.ok().build();
		}
		log.debug("[delete] itemMovimentacao NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

	/**
	 * Endpoint para inserção de ItemMovimentacao.
	 *
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/api/itemMovimentacaos")
	public ResponseEntity<?> insert(@RequestBody ItemMovimentacao itemMovimentacao) {
		log.debug("[insert] Requisição para inserir itemMovimentacao...");
		ItemMovimentacao insertedItemMovimentacao = itemMovimentacaoService.insert(itemMovimentacao);
		log.debug("[insert] ItemMovimentacao inserido com sucesso. id={}", insertedItemMovimentacao.getId());
		return ResponseEntity.ok(insertedItemMovimentacao);
	}

	/**
	 * Endpoint para atualização de ItemMovimentacao.
	 *
	 */
	@RequestMapping(method = RequestMethod.PUT, path = "/api/itemMovimentacaos/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ItemMovimentacao itemMovimentacao) {
		log.debug("[update] Requisição para atualizar de itemMovimentacao...");
		boolean exists = itemMovimentacaoService.exists(id);
		if (exists) {
			log.debug("[update] itemMovimentacao encontrado.");
			ItemMovimentacao updatedItemMovimentacao = itemMovimentacaoService.update(itemMovimentacao);
			log.debug("[update] itemMovimentacao atualizado com sucesso.");
			return ResponseEntity.ok(updatedItemMovimentacao);
		}
		log.debug("[update] itemMovimentacao NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

}
