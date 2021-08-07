package com.example.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class Controller {

    @GetMapping("/api/calculation")

    public CalculatorBean calculator(@RequestParam int max, @RequestParam int divisor, @RequestParam int limit){

        var calculatorBean = new CalculatorBean();

        var range = IntStream
                .rangeClosed(0, max)
                .boxed()
                .collect(Collectors.toList());

        var list = range.stream()
                .filter(subList -> subList%divisor == 0)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .map(l -> "I am " + (l+2))
                .collect(Collectors.toList());

        calculatorBean.setData(list);

        return calculatorBean;
    }
}
