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
import br.jus.tre_pa.sdu.spring.domain.Local;
import br.jus.tre_pa.sdu.spring.service.LocalService;

@RestController
@CrossOrigin
public class LocalRest {

	private Logger log = LoggerFactory.getLogger(LocalRest.class);

	@Autowired
	private LocalService localService;

	/**
	 * Endpoint para buscar todas as instâncias de Local.
	 *
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/api/locais")
	public ResponseEntity<?> findAll(Pageable pageable) {
		log.debug("[findAll] Requisição para buscar todos locals");
		Page<Local> locals = localService.findAll(pageable);
		return ResponseEntity.ok(locals);
	}


	/**
	 * Endpoint para buscar 1 (uma) instância de Local.
	 *
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/api/locais/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Long id) {
		log.debug("[find] Requisição para buscar local. id={}", id);
		boolean exists = localService.exists(id);
		if (exists) {
			log.debug("[find] local encontrado.");
			return ResponseEntity.ok(localService.findOne(id));
		}
		log.debug("[find] local NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

	/**
	 * Endpoint para deleção de Local.
	 *
	 */
	@RequestMapping(method = RequestMethod.DELETE, path = "/api/locais/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		log.debug("[delete] Requisição para deletar local. id={}", id);
		boolean exists = localService.exists(id);
		if (exists) {
			log.debug("[delete] local encontrado.");
			localService.delete(id);
			log.debug("[delete] local deletado com sucesso.");
			return ResponseEntity.ok().build();
		}
		log.debug("[delete] local NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

	/**
	 * Endpoint para inserção de Local.
	 *
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/api/locais")
	public ResponseEntity<?> insert(@RequestBody Local local) {
		log.debug("[insert] Requisição para inserir local...");
		Local insertedLocal = localService.insert(local);
		log.debug("[insert] Local inserido com sucesso. id={}", insertedLocal.getId());
		return ResponseEntity.ok(insertedLocal);
	}

	/**
	 * Endpoint para atualização de Local.
	 *
	 */
	@RequestMapping(method = RequestMethod.PUT, path = "/api/locais/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Local local) {
		log.debug("[update] Requisição para atualizar de local...");
		boolean exists = localService.exists(id);
		if (exists) {
			log.debug("[update] local encontrado.");
			Local updatedLocal = localService.update(local);
			log.debug("[update] local atualizado com sucesso.");
			return ResponseEntity.ok(updatedLocal);
		}
		log.debug("[update] local NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

}
