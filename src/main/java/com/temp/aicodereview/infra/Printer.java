package com.temp.aicodereview.infra;

import com.temp.aicodereview.domain.car.Car;
import com.temp.aicodereview.domain.controller.Message;

import java.util.List;

public interface Printer {

    void printBlank();
    void print(Message message);
    void print(Car car);
    void printWinner(List<Car> car);
}
