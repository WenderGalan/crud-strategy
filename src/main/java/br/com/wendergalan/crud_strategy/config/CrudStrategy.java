package br.com.wendergalan.crud_strategy.config;

import java.util.List;

public interface CrudStrategy<T> {
    T create(T entity);

    T read(Long id);

    T update(T entity);

    void delete(Long id);

    List<T> findAll();
}
