package com.example.android.calculator.model;

import android.util.Log;

public class Calculator {
    // todo: resolve overflow, big numbers
    // todo: resolve division by zero
    private long memory = 0;

    private MathOperator inMemoryOp = null;

    private String newNum = "0";

    private void add() {
        memory += Long.parseLong(newNum);
    }

    private void sub() {
        memory -= Long.parseLong(newNum);
    }

    private void mul() {
        memory = memory * Long.parseLong(newNum);
    }

    private void div() {
        memory = memory / Long.parseLong(newNum);
    }

    // return currently viewed string
    public String appendNumber(String digit) {
        if (newNum.equals("0")) {
            if (!digit.equals("0")) {
                newNum = digit;
            }
        } else {
            newNum = newNum + digit;
        }
        return newNum;
    }

    private void logAll() {
        Log.i(this.getClass().getSimpleName(), "memory: " + memory);
        Log.i(this.getClass().getSimpleName(), "memoryOp: " + inMemoryOp);
        Log.i(this.getClass().getSimpleName(), "viewed " + newNum);
    }

    public long operation(MathOperator op) {
        if (inMemoryOp == null) {
            inMemoryOp = op;
            memory = Integer.parseInt(newNum);
            newNum = "0";
            logAll();
            return memory;
        }
        switch (inMemoryOp) {
            case ADD:
                add();
                break;
            case SUB:
                sub();
                break;
            case MUL:
                mul();
                break;
            case DIV:
                div();
                break;
            case EQUALS:
                break;
        }
        newNum = "0";
        inMemoryOp = op;
        logAll();
        return memory;
    }

    public void reset() {
        memory = 0;
        newNum = "0";
        inMemoryOp = null;
    }


}
