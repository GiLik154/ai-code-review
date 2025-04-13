package com.temp.aicodereview.domain.controller;

import com.temp.aicodereview.infra.MockPrinter;
import com.temp.aicodereview.infra.MockReader;
import com.temp.aicodereview.infra.MockRole;
import org.junit.jupiter.api.Test;

class ControllerTest {

    @Test
    void 리더를_2번_호출해야_한다() {
        MockRole mockRole = MockRole.create();
        MockReader reader = MockReader.create();
        MockPrinter printer = MockPrinter.create();

        Controller controller = new Controller(mockRole, reader, printer);
        controller.startGame();

        reader.verify(1, 1);
    }

    @Test
    void 내용을_출력할_수_있어야_한다() {
        MockRole mockRole = MockRole.create();
        MockReader reader = MockReader.create();
        MockPrinter printer = MockPrinter.create();

        Controller controller = new Controller(mockRole, reader, printer);
        controller.startGame();

        printer.verify(Message.PRINT_RACE_COUNT.toString());
        printer.verify(Message.PRINT_RESULT.toString());
        printer.verify("TEST");
    }

    @Test
    void 차_대수를_3을_입력하면_() {
        MockRole mockRole = MockRole.create();
        MockReader reader = MockReader.create();
        MockPrinter printer = MockPrinter.create();

        Controller controller = new Controller(mockRole, reader, printer);
        controller.startGame();

        printer.verify(Message.PRINT_RACE_COUNT.toString());
        printer.verify(Message.PRINT_RESULT.toString());
    }
}