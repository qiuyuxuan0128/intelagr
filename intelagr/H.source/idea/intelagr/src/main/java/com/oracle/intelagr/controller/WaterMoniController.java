package com.oracle.intelagr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/waterMoni")
public class WaterMoniController {
    @RequestMapping("/list")
    public String list(){
        return "/watermoni/waterMoniList";
    }
}
