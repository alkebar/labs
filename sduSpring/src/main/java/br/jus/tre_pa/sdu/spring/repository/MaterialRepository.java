package br.jus.tre_pa.sdu.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.jus.tre_pa.sdu.spring.domain.Material;
import java.util.List;
import org.springframework.data.jpa.repository.Query;       
import br.jus.tre_pa.sdu.spring.domain.ItemMovimentacao;     

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
	
	@Query(" select itemMovimentaca from Material material join material.itemMovimentacao itemMovimentaca where material.id = ?1 ")
	List<ItemMovimentacao> findItemMovimentacao(Long id);

}