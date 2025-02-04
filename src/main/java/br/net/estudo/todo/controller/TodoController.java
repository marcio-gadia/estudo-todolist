package br.net.estudo.todo.controller;

import java.util.List;

import org.jboss.resteasy.reactive.RestResponse;

import br.net.estudo.todo.entity.Todo;
import br.net.estudo.todo.service.TodoService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;


@Path("/to-do")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @POST
    @Path("/create")
    @Transactional
    public RestResponse <List<Todo>> create(Todo todo){
        List<Todo> listTodo =  todoService.criarTodo(todo);
        return RestResponse.ok(listTodo);
    }

    @GET
    @Path("/list")
    @Transactional    
    public RestResponse <List<Todo>> list(){
        List<Todo> listTodo = todoService.listarTodos();
        return RestResponse.ok(listTodo);
    }

    @PUT
    @Path("/update")
    @Transactional
    public RestResponse <List<Todo>> update(Todo todo){
        List<Todo> listTodo = todoService.alterarTodo(todo);
        return RestResponse.ok(listTodo);

    }

    @DELETE
    @Path("/delete?{id}")
    @Transactional
    public RestResponse <List<Todo>> delete(Long id){
        List<Todo> listTodo = todoService.excluirTodo(id);
        return RestResponse.ok(listTodo);
    }    

}
