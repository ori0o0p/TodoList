package com.dsm.todolist.internal.data.repository;

import com.dsm.todolist.internal.core.domain.model.primitive.Todo;

record TodoListElementEntity(
        String todo,
        boolean isSuccess
) {

    TodoListElementEntity(final Todo todo) {
        this(todo.value(), false);
    }

}
