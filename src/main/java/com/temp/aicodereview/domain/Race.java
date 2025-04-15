package com.temp.aicodereview.domain;

import com.temp.aicodereview.domain.car.Car;
import com.temp.aicodereview.domain.car.Position;
import com.temp.aicodereview.domain.role.DriveRole;
import com.temp.aicodereview.domain.role.Policy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Race {

    private final List<Car> cars;
    private final Policy policy;

    public Race(String carNames, DriveRole driveRole) {
        String[] names = carNames.split(",");

        this.cars = Arrays.stream(names)
                           .map(Car::new)
                           .toList();
        this.policy = new Policy(driveRole);
    }

    public List<Car> move() {
        return cars.stream().map(car -> car.move(policy))
                .toList();
    }

    public List<Car> getWinner() {
        List<Position> positions = cars.stream()
                                       .map(Car::getPosition)
                                       .toList();

        Position winner = positions.stream()
                                   .max(Comparator.comparing(Position::distance))
                                   .orElseThrow();

        return cars.stream()
                   .filter(car -> car.equalsPosition(winner))
                   .toList();
    }
}