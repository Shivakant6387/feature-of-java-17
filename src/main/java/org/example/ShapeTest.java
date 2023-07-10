package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ShapeTest {
    @Test
    public void shapeTest() {
        /**
         * Permitted classes RECTANGLE and SQUARE
         */
        //Rectangle Declaration and tests
        Rectangle rectangle = new Rectangle(3, 5);
        assertEquals(16, rectangle.getPerimeter());
        assertEquals(15, rectangle.getArea(3, 5));
        //Square Declaration and tests
        Square square = new Square(3, 3);
        assertEquals(12, square.getPerimeter());
        assertEquals(9, square.getArea(3, 3));
        /**
         * Unpermitted Class TRIANGLE
         */
        Triangle triangle = new Triangle(6, 5, 5, 4);
        assertEquals(16, triangle.getPerimeter());
        assertEquals(12, triangle.getArea());
    }
}
