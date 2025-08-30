# RealEstateApp 🏡

This repository contains my work on the **RealEstateApp** project, used for practicing **unit testing with JUnit 5**. The project simulates a simple tool for real estate agents and provides a playground for writing structured, repeatable, and maintainable unit tests.

## 📚 Project Overview

The **RealEstateApp** is a stub project that models real estate data and allows us to test core concepts such as:

* Writing **parameterized tests**
* Testing for **expected exceptions**
* Handling **edge cases** like empty collections
* Repeated testing for **randomized results**
* Practicing **JUnit 5 features** like `@RepeatedTest`, `@ParameterizedTest`, `@Nested`, and conditional test execution

## 🏠 Classes in the App

1. **Apartment**

    * Represents an apartment with an `area` and `price`.

2. **ApartmentRater**

    * Rates the **price-to-area ratio** for a given apartment.
    * Possible ratings:

        * `0` → best price/area ratio
        * `1` → average ratio
        * `2` → worst ratio

3. **RandomApartmentGenerator**

    * Generates apartments with random values.
    * If no parameters are given:

        * Minimum area = `30.0 m²`
        * Minimum price/m² = `3000.0`
    * You can also specify custom min values.
    * Maximums are always `min * 4.0`.

## 🧪 Unit Tests Written

### **ApartmentRater Tests**

* ✅ **should\_ReturnCorrectRating\_When\_CorrectApartment**
  Parameterized test with different `area` and `price` values.

* ✅ **should\_ReturnErrorValue\_When\_IncorrectApartment**
  Tests handling of invalid apartment inputs (e.g., area ≤ 0 or price ≤ 0).

* ✅ **should\_CalculateAverageRating\_When\_CorrectApartmentList**
  Ensures the average rating is calculated correctly for a list of apartments.

* ✅ **should\_ThrowExceptionInCalculateAverageRating\_When\_EmptyApartmentList**
  Confirms that an exception is thrown when calculating the average for an empty list.

---

### **RandomApartmentGenerator Tests**

* ✅ **should\_GenerateCorrectApartment\_When\_DefaultMinAreaMinPrice**
  Verifies that randomly generated apartments fall within expected bounds using default values.

* ✅ **should\_GenerateCorrectApartment\_When\_CustomMinAreaMinPrice**
  Ensures apartments respect the custom minimum/maximum ranges when provided.

> Since results are random, these tests are wrapped in **@RepeatedTest** to check consistency across multiple runs.

---

## 🧪 JUnit 5 Features Practiced

* **@ParameterizedTest** → test with multiple inputs (using `@CsvSource`, etc.)
* **@RepeatedTest** → validate results from random generators multiple times
* **@Test & @Disabled** → basic and temporarily skipped tests
* **@Nested** → organize related test classes (e.g., ApartmentRater tests vs. Generator tests)
* **@BeforeEach / @AfterEach** → test lifecycle management

## 🎯 Learning Outcomes

By completing this project, I practiced how to:

* Write **unit tests for both deterministic and random logic**
* Apply **JUnit 5 advanced features** like parameterized and repeated tests
* Handle **error cases and invalid inputs** gracefully
* Structure tests using **nested classes and tags** for better organization
* Follow **TDD-style thinking** when approaching new functionality
