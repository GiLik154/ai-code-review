package com.temp.aicodereview.domain.controller;

public enum Message {

    PRINT_CAR_NAME("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    PRINT_CAR_COUNT("자동차 대수는 몇 대 인가요?"),
    PRINT_RACE_COUNT("시도할 회수는 몇 회 인가요?"),
    PRINT_RESULT("실행 결과"),
    PRINT_WINNER("가 최종 우승했습니다."),
    BLANK("");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
