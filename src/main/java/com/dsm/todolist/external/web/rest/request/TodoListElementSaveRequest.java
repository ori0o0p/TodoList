package com.dsm.todolist.external.web.rest.request;

import com.dsm.todolist.internal.core.domain.model.primitive.Todo;

public record TodoListElementSaveRequest(
        Todo todo
) {
}
