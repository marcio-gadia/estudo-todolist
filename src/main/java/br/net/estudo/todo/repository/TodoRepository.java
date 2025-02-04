package br.net.estudo.todo.repository;

import br.net.estudo.todo.entity.Todo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface TodoRepository extends PanacheRepository<Todo> {

}
