package com.company;

public class Test {
    private String objectName;
    private boolean mark;

    public Test() {
        this.objectName = "Temporary";
        this.mark = false;
    }

    Test(String objectName, boolean mark) {
        this.objectName = objectName;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return " " + objectName + ", сдал = " + mark;
    }
}
