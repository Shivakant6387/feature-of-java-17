package org.example;

public  sealed interface ShapeService permits Square, Rectangle {
    default int getArea(int a, int b) {
        return a * b;
    }
    int getPerimeter();
}
