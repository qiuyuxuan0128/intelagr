package com.oracle.intelagr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/year")
public class YearCodeController {
    @RequestMapping("/list")
    public String list(){
        return "yearcode/yearcodeList";
    }
}
