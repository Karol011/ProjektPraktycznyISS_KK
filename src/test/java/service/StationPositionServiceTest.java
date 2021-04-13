package service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StationPositionServiceTest {
    StationPositionService stationPositionService = new StationPositionService();

    @Test
    void shouldThrowExceptionWhenFirstLattitudeNotInRange() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                stationPositionService.calculateDistanceBetweenTwoPoints(1234, 10, 10, 10));
    }
    @Test
    void shouldThrowExceptionWhenSecondLattitudeNotInRange() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                stationPositionService.calculateDistanceBetweenTwoPoints(-40, 10, -888, 10));
    }
    @Test
    void shouldThrowExceptionWhenFirstLongitudeNotInRange() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                stationPositionService.calculateDistanceBetweenTwoPoints(-40, 1723, -888, 10));
    }@Test
    void shouldThrowExceptionWhenSecondLongitudeNotInRange() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                stationPositionService.calculateDistanceBetweenTwoPoints(-40, 44, -888, -190));
    }
}