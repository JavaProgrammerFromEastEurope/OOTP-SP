package com.company;

import java.io.Serializable;

public class Test implements Serializable {
    public String objectName;
    public boolean mark;
    public Test() {
        this.objectName = "Temporary";
        this.mark = false;
    }
    public Test(String objectName, boolean mark) {
        this.objectName = objectName;
        this.mark = mark;
    }
    @Override
    public String toString() {
        return " " + objectName + ", сдал = " + mark;
    }
}
