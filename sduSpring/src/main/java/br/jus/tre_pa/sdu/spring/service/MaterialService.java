package br.jus.tre_pa.sdu.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import br.jus.tre_pa.sdu.spring.domain.Material;
import br.jus.tre_pa.sdu.spring.repository.MaterialRepository;
import java.util.List;
import br.jus.tre_pa.sdu.spring.domain.ItemMovimentacao;
import br.jus.tre_pa.sdu.spring.repository.ItemMovimentacaoRepository;	

@Service
public class MaterialService {

	@Autowired
	private MaterialRepository materialRepository;

	@Autowired
	private ItemMovimentacaoRepository itemMovimentacaoRepository;	

	public Page<Material> findAll(Pageable pageable) {
		return materialRepository.findAll(pageable);
	}

	public List<ItemMovimentacao> findItemMovimentacao(Long id) {
		return materialRepository.findItemMovimentacao(id);
	}

	public Material findOne(Long id) {
		return materialRepository.findOne(id);
	}

	public boolean exists(Long id) {
		return materialRepository.exists(id);
	}

	@Transactional
	public void delete(Long id) {
		materialRepository.delete(id);
	}
	
	@Transactional
	public Material insert(Material newMaterial) {
		Material material = new Material();
		this.updateAttributes(material, newMaterial);
		return materialRepository.save(material);
	}
	
	@Transactional
	public Material update(Material newMaterial) {
		Material material = materialRepository.findOne(newMaterial.getId());
		this.updateAttributes(material, newMaterial);
		return materialRepository.save(material);
	}

	private void updateAttributes(Material material, Material newMaterial) {
		material.setOrdemRelevancia(newMaterial.getOrdemRelevancia());
		material.setPeso(newMaterial.getPeso());
		material.setValorUnitario(newMaterial.getValorUnitario());
		material.setMaterialType(newMaterial.getMaterialType());
		material.setNome(newMaterial.getNome());
		material.setDescricao(newMaterial.getDescricao());
		updateItemMovimentacao(material, newMaterial);	
	}
			
	/**
	 * Atualiza o associação bidirecional OneToMany entre Material e ItemMovimentacao
	 * 
	 */
	private void updateItemMovimentacao(Material material, Material newMaterial) {
		materialRepository.save(material);			
	}
}
