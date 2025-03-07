package com.dsm.todolist.internal.core.domain.model.primitive;

import com.dsm.todolist.internal.common.assertion.AssertionUtils;
import com.fasterxml.jackson.annotation.JsonValue;

public record Key(
        @JsonValue
        String key
) {

    public Key {
        AssertionUtils.notBlank(key, "키가 입력되지 않았습니다.");
    }

    public String value() {
        return key;
    }

}
