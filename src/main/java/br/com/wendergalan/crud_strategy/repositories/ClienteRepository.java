package br.com.wendergalan.crud_strategy.repositories;

import br.com.wendergalan.crud_strategy.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
