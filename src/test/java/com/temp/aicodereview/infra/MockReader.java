package com.temp.aicodereview.infra;

public class MockReader implements Reader {

    private int readIntCount;
    private int readIntString;

    private MockReader() {}

    public static MockReader create() {
        return new MockReader();
    }

    @Override
    public int readInt() {
        readIntCount++;

        return 0;
    }

    @Override
    public String readString() {
        readIntString++;

        return "TEST";
    }

    public void verify(int readIntCount, int readIntString) {
        if (this.readIntCount != readIntCount) {
            throw new AssertionError("readIntCount not verify want " + readIntCount + " but " + this.readIntCount);
        }

        if (this.readIntString != readIntString) {
            throw new AssertionError("readIntString not verify want " + readIntString + " but " + this.readIntString);
        }
    }
}