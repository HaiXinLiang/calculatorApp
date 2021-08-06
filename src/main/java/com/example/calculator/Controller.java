package com.example.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @GetMapping("/api/calculation")

    public CalculatorBean calculator(@RequestParam int max, @RequestParam int divisor, @RequestParam int limit){
        var calculatorBean = new CalculatorBean();

        List<String> list = new ArrayList<>();

        while (list.size() < limit){
            if(max%divisor == 0)
                list.add("I am " + (max + 2));
            max--;
        }
        calculatorBean.setData(list);

//        for(int i = max; i > 0; i--){
//            if(i%divisor ==0) {
//                list.add(i + 2);
//                if(list.size() == limit) break;
//            }
//        }

        return calculatorBean;
    }
}
