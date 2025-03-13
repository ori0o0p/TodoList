package com.dsm.todolist.internal.data.repository;

import com.dsm.todolist.internal.core.domain.model.dto.TodoListElementDTO;
import com.dsm.todolist.internal.core.domain.model.primitive.Key;
import com.dsm.todolist.internal.core.domain.model.primitive.Todo;

import java.util.List;

public interface TodoListRepository {

    Key save(Todo todo);

    void save(TodoListElementDTO dto);

    void delete(Key key);

    void deleteAll();

    TodoListElementDTO findById(Key key);

    List<TodoListElementDTO> findAll();

    List<TodoListElementDTO> findSuccessfulTodoList();

    List<TodoListElementDTO> findUnSuccessfulTodoList();

}
