package br.jus.tre_pa.sdu.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.jus.tre_pa.sdu.spring.domain.Material;
import org.springframework.data.jpa.repository.Query;       
import java.util.List;
import br.jus.tre_pa.sdu.spring.domain.ItemMovimentacao;	

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
	
	@Query(" select itemMovimentacao from Material material join material.itemMovimentacao itemMovimentacao where material.id = ?1 ")
	List<ItemMovimentacao> findItemMovimentacao(Long id);
}