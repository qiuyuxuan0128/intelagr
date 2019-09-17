package com.oracle.intelagr.controller;

import com.oracle.intelagr.common.Constants;
import com.oracle.intelagr.entity.GeneLandRegD;
import com.oracle.intelagr.service.IGeneLandRegDService;
import com.oracle.intelagr.service.IServialNumService;
import com.oracle.intelagr.service.impl.GeneLandRegDService;
import com.oracle.intelagr.service.impl.ServialNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/geneLandReg")
public class GeneLandRegController {
    @Autowired
    private  IServialNumService servialNumService;
    @Autowired
    private IGeneLandRegDService geneLandRegDService;
    @RequestMapping("/list")
    public String list(Map map){
        List<GeneLandRegD> regDList = geneLandRegDService.selectAll();
        String servialNum=servialNumService.getServialNum(Constants.BIZ_TYPE_PT);
        map.put("regDList",regDList);
        map.put("servialNum",servialNum);
        return "/genelandreg/geneLandRegList";
    }
    @RequestMapping("/editInput")
    public String editInput(){
        return "/genelandreg/geneLandRegEdit";
    }

}
