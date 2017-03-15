package br.jus.tre_pa.sdu.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.jus.tre_pa.sdu.spring.domain.ItemMovimentacao;
import org.springframework.data.jpa.repository.Query;       
import java.util.List;

@Repository
public interface ItemMovimentacaoRepository extends JpaRepository<ItemMovimentacao, Long> {
	
}