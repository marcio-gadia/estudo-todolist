package br.net.estudo.todo.service;

import java.util.List;

import br.net.estudo.todo.entity.Todo;
import br.net.estudo.todo.repository.TodoRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> listarTodos () {
        Sort sort = Sort.by("prioridade").descending().and("nome").ascending();
      
        return todoRepository.listAll(sort);
    }

    public List<Todo> criarTodo (Todo todo) {

        todoRepository.persist(todo);

        return listarTodos();

    }

    public List<Todo> alterarTodo (Todo todo) {

        todoRepository.update("nome = ?1, descricao = ?2, realizado = ?3, prioridade = ?4 where = ?5",
                       todo.getNome(),
                       todo.getDescricao(),
                       todo.getRealizado(),
                       todo.getPrioridade(),
                       todo.getId()
                      );
        return listarTodos();
    }    

    public List<Todo> excluirTodo (Long id) {

        todoRepository.deleteById(id);

        return listarTodos();
    }

}
