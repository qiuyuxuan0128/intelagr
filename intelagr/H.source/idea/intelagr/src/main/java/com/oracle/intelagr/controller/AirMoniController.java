package com.oracle.intelagr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/airMoni")
public class AirMoniController {
    @RequestMapping("/list")
    public String list(){
        return "airmoni/airMoniList";
    }
}
