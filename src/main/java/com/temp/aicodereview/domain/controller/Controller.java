package com.temp.aicodereview.domain.controller;

import com.temp.aicodereview.domain.Race;
import com.temp.aicodereview.domain.car.Car;
import com.temp.aicodereview.domain.role.DriveRole;
import com.temp.aicodereview.infra.Printer;
import com.temp.aicodereview.infra.Reader;

import java.util.List;

public class Controller {

    private final DriveRole role;
    private final Reader reader;
    private final Printer printer;

    public Controller(DriveRole role, Reader reader, Printer printer) {
        this.role = role;
        this.reader = reader;
        this.printer = printer;
    }

    public void startGame() {
        String carNames = readCarName();

        int raceCount = readRaceCount();

        play(new Race(carNames, role), raceCount);
    }

    private String readCarName() {
        printer.print(Message.PRINT_CAR_NAME);

        return reader.readString();
    }

    private int readRaceCount() {
        printer.print(Message.PRINT_RACE_COUNT);

        return reader.readInt();
    }

    private void play(Race race, int raceCount) {
        printer.print(Message.PRINT_RESULT);

        for (int i = 0; i < raceCount; i++) {
            List<Car> result = race.move();
            result.forEach(printer::print);
            printer.printBlank();
        }

        printWinner(race.getWinner());
    }

    private void printWinner(List<Car> winner) {
        printer.printWinner(winner);
    }
}
