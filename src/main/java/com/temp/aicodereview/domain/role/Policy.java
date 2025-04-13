package com.temp.aicodereview.domain.role;

public class Policy {

    private final DriveRole driveRole;

    public Policy(DriveRole driveRole) {
        this.driveRole = driveRole;
    }

    public boolean canMove() {
        return driveRole.canMove();
    }
}
