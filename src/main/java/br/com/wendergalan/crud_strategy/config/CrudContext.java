package br.com.wendergalan.crud_strategy.config;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CrudContext {
    private final Map<String, CrudStrategy<?>> strategies;

    public CrudContext(List<CrudStrategy<?>> strategyList) {
        this.strategies = strategyList.stream()
                .collect(Collectors.toMap(
                        s -> s.getClass().getSimpleName().toLowerCase(),
                        s -> s
                ));
    }

    @SuppressWarnings("unchecked")
    public <T> CrudStrategy<T> getStrategy(String strategyName) {
        return (CrudStrategy<T>) strategies.get(strategyName.toLowerCase());
    }
}
