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
import br.jus.tre_pa.sdu.spring.domain.Material;
import br.jus.tre_pa.sdu.spring.domain.ItemMovimentacao;  
import br.jus.tre_pa.sdu.spring.service.MaterialService;

@RestController
public class MaterialRest {

	private Logger log = LoggerFactory.getLogger(MaterialRest.class);

	@Autowired
	private MaterialService materialService;

	/**
	 * Endpoint para buscar todas as instâncias de Material.
	 *
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/api/materiais")
	public ResponseEntity<?> findAll(Pageable pageable) {
		log.debug("[findAll] Requisição para buscar todos materials");
		Page<Material> materials = materialService.findAll(pageable);
		return ResponseEntity.ok(materials);
	}


	/**
	 * Endpoint para buscar 1 (uma) instância de Material.
	 *
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/api/materiais/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Long id) {
		log.debug("[find] Requisição para buscar material. id={}", id);
		boolean exists = materialService.exists(id);
		if (exists) {
			log.debug("[find] material encontrado.");
			return ResponseEntity.ok(materialService.findOne(id));
		}
		log.debug("[find] material NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

	/**
	 * Endpoint para deleção de Material.
	 *
	 */
	@RequestMapping(method = RequestMethod.DELETE, path = "/api/materiais/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		log.debug("[delete] Requisição para deletar material. id={}", id);
		boolean exists = materialService.exists(id);
		if (exists) {
			log.debug("[delete] material encontrado.");
			materialService.delete(id);
			log.debug("[delete] material deletado com sucesso.");
			return ResponseEntity.ok().build();
		}
		log.debug("[delete] material NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

	/**
	 * Endpoint para inserção de Material.
	 *
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/api/materiais")
	public ResponseEntity<?> insert(@RequestBody Material material) {
		log.debug("[insert] Requisição para inserir material...");
		Material insertedMaterial = materialService.insert(material);
		log.debug("[insert] Material inserido com sucesso. id={}", insertedMaterial.getId());
		return ResponseEntity.ok(insertedMaterial);
	}

	/**
	 * Endpoint para atualização de Material.
	 *
	 */
	@RequestMapping(method = RequestMethod.PUT, path = "/api/materiais/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Material material) {
		log.debug("[update] Requisição para atualizar de material...");
		boolean exists = materialService.exists(id);
		if (exists) {
			log.debug("[update] material encontrado.");
			Material updatedMaterial = materialService.update(material);
			log.debug("[update] material atualizado com sucesso.");
			return ResponseEntity.ok(updatedMaterial);
		}
		log.debug("[update] material NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

}
