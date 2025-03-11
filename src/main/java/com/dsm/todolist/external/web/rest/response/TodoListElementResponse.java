package com.dsm.todolist.external.web.rest.response;

import com.dsm.todolist.internal.core.domain.model.dto.TodoListElementDTO;
import com.dsm.todolist.internal.core.domain.model.primitive.IsSuccess;
import com.dsm.todolist.internal.core.domain.model.primitive.Key;
import com.dsm.todolist.internal.core.domain.model.primitive.Todo;

public record TodoListElementResponse(
        Key key,
        Todo todo,
        IsSuccess isSuccess
) {

    public static TodoListElementResponse fromDTO(final TodoListElementDTO dto) {
        return new TodoListElementResponse(dto.key(), dto.todo(), dto.isSuccess());
    }

}
