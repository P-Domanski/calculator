package com.example.calculator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("calculator")
public class RequestHandler {

    @GetMapping
    public String helloSpringBoot() {
        return "Hello There!\n\tWelcome to the calculator API!";
    }

    @GetMapping("add")
    public ResponseEntity additionHandler(@RequestParam Double value1, @RequestParam Double value2) {
        Double calculationResult = CalculatorLogicCore.addition(value1, value2);
        Map<String, Double> responseBody = new HashMap<>();
        responseBody.put("result", calculationResult);
        return ResponseEntity.ok(responseBody); // 200 OK
    }

    @GetMapping("sub")
    public ResponseEntity substractionHandler(@RequestParam Double value1, @RequestParam Double value2) {
        Double calculationResult = CalculatorLogicCore.substraction(value1, value2);
        Map<String, Double> responseBody = new HashMap<>();
        responseBody.put("result", calculationResult);
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("multi")
    public ResponseEntity multiplicationHandler(@RequestParam Double value1, @RequestParam Double value2) {
        Double calculationResult = CalculatorLogicCore.multiplication(value1, value2);
        Map<String, Double> responseBody = new HashMap<>();
        responseBody.put("result", calculationResult);
        return ResponseEntity.ok(responseBody); // 200 OK
    }

    @GetMapping("div")
    public ResponseEntity divisionHandler(@RequestParam Double value1, @RequestParam Double value2) {
        if (value2 == 0) {
            return ResponseEntity.badRequest().body("Division by 0");
        }
        Map<String, Double> responseBody = new HashMap<>();
        Double calculationResult = CalculatorLogicCore.division(value1, value2);
        responseBody.put("result", calculationResult);
        return ResponseEntity.ok(responseBody);
    }
}