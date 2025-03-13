package com.dsm.todolist.internal.core.domain.model.dto;

import com.dsm.todolist.internal.core.domain.model.primitive.IsSuccess;
import com.dsm.todolist.internal.core.domain.model.primitive.Key;
import com.dsm.todolist.internal.core.domain.model.primitive.Todo;

public record TodoListElementDTO(
        Key key,
        Todo todo,
        IsSuccess isSuccess
) {

    public TodoListElementDTO success() {
        return new TodoListElementDTO(key, todo, IsSuccess.getTrueInstance());
    }

}
