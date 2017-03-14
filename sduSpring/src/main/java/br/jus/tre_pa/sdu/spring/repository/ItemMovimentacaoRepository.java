package br.jus.tre_pa.sdu.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.jus.tre_pa.sdu.spring.domain.ItemMovimentacao;
import java.util.List;
import org.springframework.data.jpa.repository.Query;       

@Repository
public interface ItemMovimentacaoRepository extends JpaRepository<ItemMovimentacao, Long> {
	
}