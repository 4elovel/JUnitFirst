package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AreaServiceTest {

    @Test
    public void testTriangleArea() {
        assertEquals(6.0, AreaService.triangleArea(4, 3), 0.001);
    }

    @Test
    public void testTriangleAreaWithInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            AreaService.triangleArea(-1, 3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            AreaService.triangleArea(4, -1);
        });
    }

    @Test
    public void testRectangleArea() {
        assertEquals(20.0, AreaService.rectangleArea(4, 5), 0.001);
    }

    @Test
    public void testRectangleAreaWithInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            AreaService.rectangleArea(-4, 5);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            AreaService.rectangleArea(4, -5);
        });
    }

    @Test
    public void testSquareArea() {
        assertEquals(16.0, AreaService.squareArea(4), 0.001);
    }

    @Test
    public void testSquareAreaWithInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            AreaService.squareArea(-4);
        });
    }

    @Test
    public void testRhombusArea() {
        assertEquals(10.0, AreaService.rhombusArea(4, 5), 0.001);
    }

    @Test
    public void testRhombusAreaWithInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            AreaService.rhombusArea(-4, 5);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            AreaService.rhombusArea(4, -5);
        });
    }
}
