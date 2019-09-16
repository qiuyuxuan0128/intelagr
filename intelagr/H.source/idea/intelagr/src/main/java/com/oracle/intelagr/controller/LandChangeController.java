package com.oracle.intelagr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/landChange")
public class LandChangeController {
    @RequestMapping("/editInput")
    public String editInput(){

        return "landchange/landChangeEdit";
    }

    @RequestMapping("/list")
    public String list(){

        return "landchange/landChangeList";
    }

    @RequestMapping("/listquery")
    public String listQuery(){

        return "landchange/landChangeListQuery";
    }

}
