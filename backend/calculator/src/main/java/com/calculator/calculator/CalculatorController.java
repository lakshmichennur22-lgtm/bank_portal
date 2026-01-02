package com.calculator.calculator;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
@CrossOrigin(origins = "*") // ✅ Allow React frontend

public class CalculatorController {

    @GetMapping("/fd")
    public double calculateFD(@RequestParam double principal,
            @RequestParam double rate,
            @RequestParam double time) {
        return principal * Math.pow(1 + rate / 100, time);
    }

    @GetMapping("/rd")
    public double calculateRD(@RequestParam double monthlyInvestment,
            @RequestParam double rate,
            @RequestParam double time) {
        double r = rate / 100 / 12;
        return monthlyInvestment * (Math.pow(1 + r, time) - 1) / r;
    }

    @GetMapping("/emi")
    public double calculateEMI(@RequestParam double principal,
            @RequestParam double rate,
            @RequestParam double tenure) {
        double r = rate / 12 / 100;
        int n = (int) (tenure * 12);
        return (principal * r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
    }

    @GetMapping("/simple-interest")
    public double simpleInterest(@RequestParam double principal,
            @RequestParam double rate,
            @RequestParam double time) {
        return (principal * rate * time) / 100;
    }

    @GetMapping("/compound-interest")
    public double compoundInterest(@RequestParam double principal,
            @RequestParam double rate,
            @RequestParam double time) {
        return principal * Math.pow(1 + rate / 100, time) - principal;
    }
    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
