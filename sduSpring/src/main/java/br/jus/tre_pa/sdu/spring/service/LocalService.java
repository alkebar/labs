package br.jus.tre_pa.sdu.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import br.jus.tre_pa.sdu.spring.domain.Local;
import br.jus.tre_pa.sdu.spring.repository.LocalRepository;
import java.util.List;

@Service
public class LocalService {

	@Autowired
	private LocalRepository localRepository;


	
	/**
	 * Retorna uma lista de  Local com paginação. 
	 *
	 * @param pageable 
	 * @return 
	 */
	public Page<Local> findAll(Pageable pageable) {
		return localRepository.findAll(pageable);
	}


	/**
	 * Retorna uma instância de  Local pelo id. 
	 *
	 */
	public Local findOne(Long id) {
		return localRepository.findOne(id);
	}

	/**
	 * Verifica se a instância de Local existe na base de dados.
	 *
	 * @param id Id de Local.
	 * @return
	 */
	public boolean exists(Long id) {
		return localRepository.exists(id);
	}

	/**
	 * Deleta uma instância de Local.
	 * 
	 * @param id Id do objeto a ser deletado.
	 */
	@Transactional
	public void delete(Long id) {
		localRepository.delete(id);
	}
	
	/**
	 * Insere uma instância de Local na base de dados. 
	 *
	 * @param newFoo Objeto com os dados para inserção de Local.
	 * @return Local atualizado.
	 */
	@Transactional
	public Local insert(Local newLocal) {
		Local local = new Local();
		this.updateAttributes(local, newLocal);
		return localRepository.save(local);
	}
	
	/**
	 * Atualiza a instância de Local na base de dados. 
	 *
	 * @param newFoo Objeto com os dados para atualização de Local.
	 * @return Local atualizado.
	 */
	@Transactional
	public Local update(Local newLocal) {
		Local local = localRepository.findOne(newLocal.getId());
		this.updateAttributes(local, newLocal);
		return localRepository.save(local);
	}

	private void updateAttributes(Local local, Local newLocal) {
		local.setNumeroZona(newLocal.getNumeroZona());
		local.setNome(newLocal.getNome());
		local.setTelefone(newLocal.getTelefone());
		local.setEndereco(newLocal.getEndereco());
		local.setLocalType(newLocal.getLocalType());
		local.setEmail(newLocal.getEmail());
	}

}
