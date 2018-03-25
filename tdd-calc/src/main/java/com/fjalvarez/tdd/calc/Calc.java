package com.fjalvarez.tdd.calc;

public class Calc {
    protected static final int MAX_NUM_DIGITS = 9;

    String display;

    Calc() {
        display = "0";
    }
    public void press(char c) {
        if (display.length() == MAX_NUM_DIGITS) {
            return;
        }
        if (display.equals("0")) {
            display = "" + c;
        } else {
            display = display + c;
        }
    }

    public Object display() {
        return display;
    }
}
