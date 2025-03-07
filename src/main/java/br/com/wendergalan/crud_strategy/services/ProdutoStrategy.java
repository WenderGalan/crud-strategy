package br.com.wendergalan.crud_strategy.services;

import br.com.wendergalan.crud_strategy.config.CrudStrategy;
import br.com.wendergalan.crud_strategy.entities.Produto;
import br.com.wendergalan.crud_strategy.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("produtoStrategy")
@RequiredArgsConstructor
public class ProdutoStrategy implements CrudStrategy<Produto> {
    private final ProdutoRepository produtoRepository;

    @Override
    public Produto create(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Produto read(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @Override
    public Produto update(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }
}

