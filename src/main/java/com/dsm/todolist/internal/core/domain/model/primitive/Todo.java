package com.dsm.todolist.internal.core.domain.model.primitive;

import com.dsm.todolist.internal.common.assertion.AssertionUtils;
import com.fasterxml.jackson.annotation.JsonValue;

public record Todo(
        @JsonValue
        String todo
) {

    public Todo {
        AssertionUtils.notBlank(todo, "할 일이 입력되지 않았습니다.");
    }

    public String value() {
        return todo;
    }

}
