package com.dsm.todolist.external.web.graphql.input;

import com.dsm.todolist.internal.core.domain.model.primitive.Todo;

public record TodoInput(
    Todo todo
) {
}