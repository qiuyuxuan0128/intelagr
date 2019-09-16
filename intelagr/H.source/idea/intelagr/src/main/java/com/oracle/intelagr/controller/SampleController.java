package com.oracle.intelagr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class SampleController {
    @RequestMapping("/list")
    public String list(){

        return "sample/list";
    }

}
