package com.oracle.intelagr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("quality")
public class QualityController {
    @RequestMapping("/list")
    public String list(){

        return "quality/list";
    }

}
