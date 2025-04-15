package com.temp.aicodereview.view;

import com.temp.aicodereview.domain.car.Car;
import com.temp.aicodereview.domain.car.Name;
import com.temp.aicodereview.domain.controller.Message;
import com.temp.aicodereview.infra.Printer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsolPrinter implements Printer {

    @Override
    public void print(Message message) {
        System.out.println(message);
    }

    @Override
    public void print(Car car) {
        String message = IntStream.range(0, car.getPosition().distance())
                .mapToObj(i -> "-")
                .collect(Collectors.joining());

        System.out.println(message);
    }

    @Override
    public void printWinner(List<Car> car) {
        String message = car.stream()
                            .map(Car::getName)
                            .map(Name::value)
                            .collect(Collectors.joining(", "));

        System.out.print(message);
        System.out.println(Message.PRINT_WINNER);
    }

    @Override
    public void printBlank() {
        System.out.println();
    }

}
