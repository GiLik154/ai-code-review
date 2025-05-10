package com.temp.aicodereview.domain.car;

public record Name(String value) {

    private static final int MAX_SIZE = 5;

    public static Name of(String value) {
        if (value.length() > MAX_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 최대 5자리 까지 가능합니다.");
        }

        return new Name(value);
    }
}
