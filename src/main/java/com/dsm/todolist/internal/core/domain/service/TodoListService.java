package com.dsm.todolist.internal.core.domain.service;

import com.dsm.todolist.external.web.rest.response.TodoListElementKeyResponse;
import com.dsm.todolist.internal.core.domain.model.dto.TodoListElementDTO;
import com.dsm.todolist.internal.core.domain.model.primitive.Key;
import com.dsm.todolist.internal.core.domain.model.primitive.Todo;
import com.dsm.todolist.internal.core.usecase.TodoListUseCase;
import com.dsm.todolist.internal.data.repository.TodoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class TodoListService implements TodoListUseCase {

    private final TodoListRepository todoListRepository;

    @Override
    public Key add(final Todo todo) {
        return todoListRepository.save(todo);
    }

    @Override
    public void remove(final Key key) {
        todoListRepository.delete(key);
    }

    @Override
    public void init() {
        todoListRepository.deleteAll();
    }

    @Override
    public void success(final Key key) {
        final TodoListElementDTO todo = todoListRepository.findById(key);
        todoListRepository.save(todo.success());
    }

    @Override
    public List<TodoListElementDTO> getAll() {
        return todoListRepository.findAll();
    }

    @Override
    public List<TodoListElementDTO> getSuccessfulTodoList() {
        return todoListRepository.findSuccessfulTodoList();
    }

    @Override
    public List<TodoListElementDTO> getUnSuccessfulTodoList() {
        return todoListRepository.findUnSuccessfulTodoList();
    }

}
