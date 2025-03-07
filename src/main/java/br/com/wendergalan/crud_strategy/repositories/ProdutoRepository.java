package br.com.wendergalan.crud_strategy.repositories;

import br.com.wendergalan.crud_strategy.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
