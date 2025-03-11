package com.dsm.todolist.internal.core.usecase;

import com.dsm.todolist.internal.core.domain.model.dto.TodoListElementDTO;
import com.dsm.todolist.internal.core.domain.model.primitive.Key;
import com.dsm.todolist.internal.core.domain.model.primitive.Todo;

import java.util.List;

public interface TodoListUseCase {

    void add(Todo todo);

    void remove(Key key);

    void init();

    List<TodoListElementDTO> getAll();

    List<TodoListElementDTO> getSuccessfulTodoList();

    List<TodoListElementDTO> getUnSuccessfulTodoList();

}
