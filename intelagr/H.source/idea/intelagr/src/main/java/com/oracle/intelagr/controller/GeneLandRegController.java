package com.oracle.intelagr.controller;

import com.oracle.intelagr.common.Constants;
import com.oracle.intelagr.common.JsonResult;
import com.oracle.intelagr.common.PageModel;
import com.oracle.intelagr.entity.Contract;
import com.oracle.intelagr.entity.GeneLandRegD;
import com.oracle.intelagr.entity.Peasant;
import com.oracle.intelagr.service.IGeneLandRegDService;
import com.oracle.intelagr.service.IGeneLandRegService;
import com.oracle.intelagr.service.IServialNumService;
import com.oracle.intelagr.service.impl.GeneLandRegDService;
import com.oracle.intelagr.service.impl.ServialNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/geneLandReg")
public class GeneLandRegController {
    @Autowired
    private  IServialNumService servialNumService;
    @Autowired
    private IGeneLandRegService geneLandRegService;
    //普通土地备案一览
    @RequestMapping("/list")
    public String list(){
        return "/genelandreg/geneLandRegList";
    }
    //普通土地备案申请
    @RequestMapping("/editInput")
    public String editInput(Map map){

        String servialNum=servialNumService.getServialNum(Constants.BIZ_TYPE_PT);
        map.put("servialNum",servialNum);
        return "/genelandreg/geneLandRegEdit";
    }
    //确权
    @RequestMapping("/getContratorInfo")
    @ResponseBody
    public JsonResult getContratorInfo(@RequestBody Map paramMap){
        List<Peasant> peasantList = geneLandRegService.queryPeasant(paramMap);
        if(peasantList.size()>0){
            List<Contract> contracts = geneLandRegService.selectByID(peasantList.get(0).getContractorCode());
            List<Contract> contractList = geneLandRegService.Transformation(contracts);
            Map mp = new HashMap();
            mp.put("peasant",peasantList.get(0));
            mp.put("contract",contractList);
            float zmj=0;
            for(Contract c:contractList){
                zmj+=c.getMeasurementMu();
            }
            System.out.println("总面积 ："+zmj);
            mp.put("zmj",zmj);
            JsonResult result=new JsonResult(true);
            result.setData(mp);
            return  result;
        }
        return new JsonResult(false);
    }
    @RequestMapping("/addLand")
    public String  addLand(){
        return "/genelandreg/geneLandRegDEdit";
    }
}
