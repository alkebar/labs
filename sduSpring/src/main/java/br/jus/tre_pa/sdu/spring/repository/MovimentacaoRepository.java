package br.jus.tre_pa.sdu.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.jus.tre_pa.sdu.spring.domain.Movimentacao;
import org.springframework.data.jpa.repository.Query;       
import java.util.List;
import br.jus.tre_pa.sdu.spring.domain.ItemMovimentacao;	

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
	
	@Query(" select itensMovimentacao from Movimentacao movimentacao join movimentacao.itensMovimentacao itensMovimentacao where movimentacao.id = ?1 ")
	List<ItemMovimentacao> findItensMovimentacao(Long id);
}