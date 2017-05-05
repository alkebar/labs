package br.jus.tre_pa.sdu.spring.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.jus.tre_pa.sdu.spring.domain.Movimentacao;
import br.jus.tre_pa.sdu.spring.domain.ItemMovimentacao;  
import br.jus.tre_pa.sdu.spring.service.MovimentacaoService;

@RestController
@CrossOrigin
public class MovimentacaoRest {

	private Logger log = LoggerFactory.getLogger(MovimentacaoRest.class);

	@Autowired
	private MovimentacaoService movimentacaoService;

	/**
	 * Endpoint para buscar todas as instâncias de Movimentacao.
	 *
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/api/movimentacoes")
	public ResponseEntity<?> findAll(Pageable pageable) {
		log.debug("[findAll] Requisição para buscar todos movimentacaos");
		Page<Movimentacao> movimentacaos = movimentacaoService.findAll(pageable);
		return ResponseEntity.ok(movimentacaos);
	}


	/**
	 * Endpoint para buscar 1 (uma) instância de Movimentacao.
	 *
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/api/movimentacoes/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Long id) {
		log.debug("[find] Requisição para buscar movimentacao. id={}", id);
		boolean exists = movimentacaoService.exists(id);
		if (exists) {
			log.debug("[find] movimentacao encontrado.");
			return ResponseEntity.ok(movimentacaoService.findOne(id));
		}
		log.debug("[find] movimentacao NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

	/**
	 * Endpoint para deleção de Movimentacao.
	 *
	 */
	@RequestMapping(method = RequestMethod.DELETE, path = "/api/movimentacoes/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		log.debug("[delete] Requisição para deletar movimentacao. id={}", id);
		boolean exists = movimentacaoService.exists(id);
		if (exists) {
			log.debug("[delete] movimentacao encontrado.");
			movimentacaoService.delete(id);
			log.debug("[delete] movimentacao deletado com sucesso.");
			return ResponseEntity.ok().build();
		}
		log.debug("[delete] movimentacao NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

	/**
	 * Endpoint para inserção de Movimentacao.
	 *
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/api/movimentacoes")
	public ResponseEntity<?> insert(@RequestBody Movimentacao movimentacao) {
		log.debug("[insert] Requisição para inserir movimentacao...");
		Movimentacao insertedMovimentacao = movimentacaoService.insert(movimentacao);
		log.debug("[insert] Movimentacao inserido com sucesso. id={}", insertedMovimentacao.getId());
		return ResponseEntity.ok(insertedMovimentacao);
	}

	/**
	 * Endpoint para atualização de Movimentacao.
	 *
	 */
	@RequestMapping(method = RequestMethod.PUT, path = "/api/movimentacoes/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Movimentacao movimentacao) {
		log.debug("[update] Requisição para atualizar de movimentacao...");
		boolean exists = movimentacaoService.exists(id);
		if (exists) {
			log.debug("[update] movimentacao encontrado.");
			Movimentacao updatedMovimentacao = movimentacaoService.update(movimentacao);
			log.debug("[update] movimentacao atualizado com sucesso.");
			return ResponseEntity.ok(updatedMovimentacao);
		}
		log.debug("[update] movimentacao NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

}
