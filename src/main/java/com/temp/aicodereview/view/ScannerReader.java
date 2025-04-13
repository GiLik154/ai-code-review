package com.temp.aicodereview.view;


import com.temp.aicodereview.infra.Reader;

import java.util.Scanner;

public class ScannerReader implements Reader {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public int readInt() {
        return scanner.nextInt();
    }

    @Override
    public String readString() {
        return scanner.nextLine();
    }
}
