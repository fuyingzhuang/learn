package com.ambition.learn;

public class Temperature {
    private static final double ABS_ZERO_C = -273.15;

    public static double toCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double toFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    public static double toKelvin(double celsius) {
        return celsius - ABS_ZERO_C;
    }

    public static void main(String[] args) {
        double fahrenheit = 212.0;
        double celsius = toCelsius(fahrenheit);
        System.out.println(fahrenheit + " Fahrenheit is equal to " + celsius + " Celsius");

        celsius = 100.0;
        double kelvin = toKelvin(celsius);
        System.out.println(celsius + " Celsius is equal to " + kelvin + " Kelvin");
    }
}
