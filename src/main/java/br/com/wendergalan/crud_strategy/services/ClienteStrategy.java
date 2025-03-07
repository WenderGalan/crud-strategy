package br.com.wendergalan.crud_strategy.services;

import br.com.wendergalan.crud_strategy.config.CrudStrategy;
import br.com.wendergalan.crud_strategy.entities.Cliente;
import br.com.wendergalan.crud_strategy.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("clienteStrategy")
@RequiredArgsConstructor
public class ClienteStrategy implements CrudStrategy<Cliente> {
    private final ClienteRepository clienteRepository;

    @Override
    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente read(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente update(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
}

