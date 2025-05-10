package com.temp.aicodereview.infra;


import com.temp.aicodereview.domain.role.DriveRole;

import java.util.Random;

public class RandomRole implements DriveRole {

    public static final int MOVE_CONDITION = 4;
    public static final int MAX_COUNT = 10;

    @Override
    public boolean canMove() {
        Random rand = new Random();
        int randomNum = rand.nextInt(MAX_COUNT);

        return randomNum >= MOVE_CONDITION;
    }
}
