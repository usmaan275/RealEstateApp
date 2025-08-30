package com.realestateapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class RandomApartmentGeneratorTest {
    @RepeatedTest(5)
    @DisplayName("a) Should generate a correct apartment when given the default min area and min price")
    void givenDefaultMinAreaMinPrice_ReturnsCorrectApartment() {
        // given
        RandomApartmentGenerator def = new RandomApartmentGenerator();
        double minArea = 30;
        BigDecimal minPricePerSquareMeter = new BigDecimal(3000);

        // when
        Apartment apartment = def.generate();
        double area = apartment.getArea();
        BigDecimal pricerPerSquareMeter = apartment.getPrice()
                .divide(BigDecimal.valueOf(apartment.getArea()), 2, RoundingMode.HALF_UP);

        // then
        assertAll(
                () -> assertTrue(area >= minArea),
                () -> assertTrue(pricerPerSquareMeter.compareTo(minPricePerSquareMeter) >= 0)
        );
    }

    @RepeatedTest(5)
    @DisplayName("b) Should generate a correct apartment when given a custom min area and min price")
    void givenCustomMinAreaMinPrice_ReturnsCorrectApartment() {
        // given
        RandomApartmentGenerator def = new RandomApartmentGenerator(40, new BigDecimal(4000));
        double minArea = 40;
        BigDecimal minPricePerSquareMeter = new BigDecimal(4000);

        // when
        Apartment apartment = def.generate();
        double area = apartment.getArea();
        BigDecimal pricerPerSquareMeter = apartment.getPrice()
                .divide(BigDecimal.valueOf(apartment.getArea()), 2, RoundingMode.HALF_UP);

        // then
        assertAll(
                () -> assertTrue(area >= minArea),
                () -> assertTrue(pricerPerSquareMeter.compareTo(minPricePerSquareMeter) >= 0)
        );
    }
}