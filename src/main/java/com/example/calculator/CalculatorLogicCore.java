package com.example.calculator;

public class CalculatorLogicCore {
    public static Double addition(Double _value1, Double _value2) {
        return _value1 + _value2;
    }

    public static Double substraction(Double _value1, Double _value2) {
        return _value1 - _value2;
    }

    public static Double multiplication(Double _value1, Double _value2) {
        return _value1 * _value2;
    }

    public static Double division(Double _value1, Double _value2) {
        if (_value2 == 0)
            throw new IllegalArgumentException("Division by 0");
        return _value1 / _value2;
    }
}
//Java naming conventions - Bez _ underscore
//                          Nazwy klas/zmiennych
