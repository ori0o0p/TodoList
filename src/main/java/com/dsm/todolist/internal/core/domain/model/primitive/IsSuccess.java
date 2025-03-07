package com.dsm.todolist.internal.core.domain.model.primitive;

import com.fasterxml.jackson.annotation.JsonValue;

public final class IsSuccess {

    @JsonValue
    private final boolean isSuccess;

    private static final IsSuccess TRUE_INSTANCE = new IsSuccess(true);

    private static final IsSuccess FALSE_INSTANCE = new IsSuccess(false);

    private IsSuccess(final boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean value() {
        return isSuccess;
    }

    public static IsSuccess getInstance(final boolean isSuccess) {
        return isSuccess ? TRUE_INSTANCE : FALSE_INSTANCE;
    }

    public static IsSuccess getTrueInstance() {
        return TRUE_INSTANCE;
    }

    public static IsSuccess getFalseInstance() {
        return FALSE_INSTANCE;
    }

}
