package com.dsm.todolist.internal.common.random;

import java.security.SecureRandom;
import java.util.Base64;

public final class RandomStringUtils {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    private RandomStringUtils() {
        // No instances.
    }

    public static String generate(final int length) {
        final var randomBytes = new byte[length];
        SECURE_RANDOM.nextBytes(randomBytes);

        return Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(randomBytes)
                .substring(0, length);
    }

}
