package org.example;

import org.junit.Test;

public class InstanceOfPatternMatching {
    @Test

    public void instanceOfPatternMatchingTest(){
        Object o = "I am a string as an object";
        if (o instanceof String str) {
            System.out.println(str.toUpperCase());
        }
        //The following code is also valid:
        if (o instanceof String str && !str.isEmpty()) {
            System.out.println(str.toUpperCase());
        }
        Object obj = 123;
        //The following code is also valid:
        if (!(obj instanceof String str)) {
            throw new RuntimeException("Please provide string!");
        }
    }
}
