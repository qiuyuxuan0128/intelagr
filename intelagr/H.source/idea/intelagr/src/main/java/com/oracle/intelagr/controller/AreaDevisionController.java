package com.oracle.intelagr.controller;

import com.oracle.intelagr.common.JsonResult;
import com.oracle.intelagr.entity.AreaDevision;
import com.oracle.intelagr.entity.Peasant;
import com.oracle.intelagr.service.IAreaDevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/areaDevision")
public class AreaDevisionController {
    @Autowired
    private IAreaDevisionService areaDevisionService;
    @RequestMapping("/getAreaDevisions")
    @ResponseBody
    public JsonResult getAreaDevisions(@RequestBody Peasant peasant){
//        System.out.println("TownCode:"+peasant.getTownCode());
//        System.out.println("getCountryCode:"+peasant.getCountryCode());
        AreaDevision areaDevision = areaDevisionService.selectByMap(peasant);
//        System.out.println("123:"+areaDevision.getCountryName());
        JsonResult result=new JsonResult(true);
        result.setData(areaDevision);
        return result;
    }
}
