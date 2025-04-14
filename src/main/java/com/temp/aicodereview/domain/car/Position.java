package com.temp.aicodereview.domain.car;

import java.util.HashMap;
import java.util.Map;

public record
Position(int distance) {

    private static final Map<Integer, Position> CACHE = new HashMap<>();

    public Position move() {
        return CACHE.computeIfAbsent(distance + 1, Position::new);
    }

    public static Position of(int distance) {
        return CACHE.computeIfAbsent(distance, Position::new);
    }
}
