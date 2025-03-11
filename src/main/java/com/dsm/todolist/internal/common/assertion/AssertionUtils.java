package com.dsm.todolist.internal.common.assertion;

public final class AssertionUtils {

    private AssertionUtils() {
        // No instances.
    }

    public static void notBlank(
            final String value,
            final String message
    ) {
        if (value.isBlank()) {
            throw new RuntimeException(message); // TODO: 3/6/25 커스텀 예외 처리
        }
    }

    public static void notNull(
            final Object value,
            final String message
    ) {
        if (value == null) {
            throw new RuntimeException(message); // TODO: 3/7/25 커스텀 예외 처리
        }
    }

}
