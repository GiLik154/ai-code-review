package com.temp.aicodereview.infra;

import com.temp.aicodereview.domain.car.Car;
import com.temp.aicodereview.domain.car.Name;
import com.temp.aicodereview.domain.controller.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MockPrinter implements Printer {

    private final List<String> result = new ArrayList<>();

    private MockPrinter() {}

    public static MockPrinter create() {
        return new MockPrinter();
    }

    @Override
    public void printBlank() {
    }

    @Override
    public void print(Message message) {
        result.add(message.toString());
    }

    @Override
    public void print(Car car) {
        String message = IntStream.range(0, car.getPosition().distance())
                .mapToObj(i -> "-")
                .collect(Collectors.joining());

        this.result.add(message);
    }

    @Override
    public void printWinner(List<Car> car) {
        String message = car.stream()
                            .map(Car::getName)
                            .map(Name::value)
                            .collect(Collectors.joining(", "));

        this.result.add(message);
    }

    public void verify(String value) {
        if (!this.result.contains(value)) {
            throw new AssertionError();
        }
    }
}