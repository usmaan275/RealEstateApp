package com.realestateapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentRaterTest {
    @Nested
    class RateApartmentTests {
        @ParameterizedTest(name = "Area: {0}, Price: {1}. Expected rating: {2}")
        @CsvSource(value = {
                "30, 120000, 0",
                "35, 245000, 1",
                "40, 360000, 2"
        })
        @DisplayName("a) Should return correct rating when given a correct apartment - parameterized test with different values")
        void givenCorrectApartment_ReturnsCorrectRating(double areaArg, BigDecimal priceArg, int rating) {
            // given
            double area = areaArg;
            BigDecimal price = priceArg;
            Apartment apartment = new Apartment(area, price);
            int expected = rating;

            // when
            int actual = ApartmentRater.rateApartment(apartment);

            // then
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("b) Should return an error value (-1) when given an incorrect apartment")
        void givenIncorrectCorrectApartment_ReturnsErrorValue() {
            // given
            double area = 0;
            BigDecimal price = new BigDecimal("12000");
            Apartment apartment = new Apartment(area, price);
            int expected = -1;

            // when
            int actual = ApartmentRater.rateApartment(apartment);

            // then
            assertEquals(expected, actual);
        }
    }

    @Nested
    class CalculateAverageRatingTests {
        @Test
        @DisplayName("c) Should calculate average rating when given correct apartment list")
        void givenCorrectApartmentList_ReturnsAverageRating() {
            // given
            List<Apartment> apartments = new ArrayList<>(
                    Arrays.asList(
                            new Apartment(30, new BigDecimal(120000)),
                            new Apartment(35, new BigDecimal(245000)),
                            new Apartment(40, new BigDecimal(360000))
                    )
            );
            double expected = 1;

            // when
            double actual = ApartmentRater.calculateAverageRating(apartments);

            // then
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("d) Should throw exception in CalculateAverageRating() when given an empty apartment list")
        void givenEmptyApartmentList_ThrowsException() {
            // given
            List<Apartment> apartments = new ArrayList<>();
            Class<RuntimeException> expected = RuntimeException.class;

            // when
            Executable actual = () -> ApartmentRater.calculateAverageRating(apartments);

            // then
            assertThrows(expected, actual);
        }
    }
}