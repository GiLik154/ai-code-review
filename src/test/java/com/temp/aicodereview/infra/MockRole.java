package com.temp.aicodereview.infra;


import com.temp.aicodereview.domain.role.DriveRole;

import java.util.LinkedList;
import java.util.Queue;

public class MockRole implements DriveRole {

    private final Queue<Boolean> results = new LinkedList<>();

    private MockRole() {}

    public static MockRole create() {
        return new MockRole();
    }

    @Override
    public boolean canMove() {
        return !results.isEmpty() && results.poll();
    }

    public MockRole thenReturn(boolean value) {
        this.results.add(value);
        return this;
    }
}