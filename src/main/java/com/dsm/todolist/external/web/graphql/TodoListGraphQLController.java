package com.dsm.todolist.external.web.graphql;

import com.dsm.todolist.external.web.graphql.input.TodoInput;
import com.dsm.todolist.external.web.rest.response.TodoListElementKeyResponse;
import com.dsm.todolist.external.web.rest.response.TodoListElementResponse;
import com.dsm.todolist.internal.core.domain.model.primitive.Key;
import com.dsm.todolist.internal.core.usecase.TodoListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
class TodoListGraphQLController {

    private final TodoListUseCase todoListUseCase;

    @QueryMapping
    List<TodoListElementResponse> getAllTodos() {
        return todoListUseCase.getAll()
                .stream()
                .map(TodoListElementResponse::fromDTO)
                .toList();
    }

    @QueryMapping
    List<TodoListElementResponse> getSuccessfulTodos() {
        return todoListUseCase.getSuccessfulTodoList()
                .stream()
                .map(TodoListElementResponse::fromDTO)
                .toList();
    }

    @QueryMapping
    List<TodoListElementResponse> getUnsuccessfulTodos() {
        return todoListUseCase.getUnSuccessfulTodoList()
                .stream()
                .map(TodoListElementResponse::fromDTO)
                .toList();
    }

    @MutationMapping
    TodoListElementKeyResponse addTodo(@Argument final TodoInput todoInput) {
        final Key key = todoListUseCase.add(todoInput.todo());
        return new TodoListElementKeyResponse(key);
    }

    @MutationMapping
    boolean removeTodo(@Argument final Key key) {
        todoListUseCase.remove(key);
        return true;
    }

    @MutationMapping
    boolean initTodos() {
        todoListUseCase.init();
        return true;
    }

    @MutationMapping
    boolean markTodoSuccess(@Argument final Key key) {
        todoListUseCase.mark(key);
        return true;
    }

}