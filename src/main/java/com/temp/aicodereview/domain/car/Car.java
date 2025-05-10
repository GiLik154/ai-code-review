package com.temp.aicodereview.domain.car;


import com.temp.aicodereview.domain.role.Policy;

public class Car {

    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = Name.of(name);
        this.position = Position.of(0);
    }

    public Car move(Policy policy) {
        boolean move = policy.canMove();

        if (move) {
            this.position = this.position.move();
        }

        return this;
    }

    public Position getPosition() {
        return this.position;
    }

    public Name getName() {
        return name;
    }

    public boolean equalsPosition(Position position) {
        return this.position == position;
    }
}