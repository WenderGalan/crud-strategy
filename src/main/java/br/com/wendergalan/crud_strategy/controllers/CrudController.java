package br.com.wendergalan.crud_strategy.controllers;

import br.com.wendergalan.crud_strategy.config.CrudContext;
import br.com.wendergalan.crud_strategy.config.CrudStrategy;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/{entity}")
@RequiredArgsConstructor
@Tag(name = "Dynamic CRUD Controller", description = "CRUD dinâmico para diferentes entidades")
public class CrudController {

    private final CrudContext crudContext;

    @Operation(summary = "Cria uma nova entidade")
    @PostMapping
    public <T> Object create(
            @Parameter(description = "Nome da entidade") @PathVariable String entity,
            @RequestBody T body) {
        return crudContext.getStrategy(entity + "strategy").create(body);
    }

    @Operation(summary = "Busca uma entidade por ID")
    @GetMapping("/{id}")
    public <T> T read(
            @PathVariable String entity,
            @PathVariable Long id) {
        CrudStrategy<T> strategy = crudContext.getStrategy(entity + "Strategy");
        return strategy.read(id);
    }

    @Operation(summary = "Atualiza uma entidade")
    @PutMapping
    public <T> T update(
            @PathVariable String entity,
            @RequestBody T body) {
        CrudStrategy<T> strategy = crudContext.getStrategy(entity + "Strategy");
        return strategy.update(body);
    }

    @Operation(summary = "Deleta uma entidade por ID")
    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable String entity,
            @PathVariable Long id) {
        CrudStrategy<?> strategy = crudContext.getStrategy(entity + "Strategy");
        strategy.delete(id);
    }

    @Operation(summary = "Lista todas as entidades")
    @GetMapping
    public <T> List<T> findAll(@PathVariable String entity) {
        CrudStrategy<T> strategy = crudContext.getStrategy(entity + "Strategy");
        return strategy.findAll();
    }
}
