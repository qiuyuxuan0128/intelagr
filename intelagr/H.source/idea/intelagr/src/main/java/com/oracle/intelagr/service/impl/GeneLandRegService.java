package com.oracle.intelagr.service.impl;

import com.oracle.intelagr.entity.CommonData;
import com.oracle.intelagr.entity.Contract;
import com.oracle.intelagr.entity.GeneLandReg;
import com.oracle.intelagr.entity.Peasant;
import com.oracle.intelagr.mapper.ContractMapper;
import com.oracle.intelagr.mapper.PeasantMapper;
import com.oracle.intelagr.service.IGeneLandRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class GeneLandRegService implements IGeneLandRegService{
    @Autowired
    private PeasantMapper peasantMapper;
    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private CommonDataService commonDataService;

    public List<Peasant> queryPeasant(Map map) {
        return peasantMapper.selectById(map);
    }
    public GeneLandReg queryOne(Map map) {
        return null;
    }
    public List<Contract> selectByID(String ContractorCode) {
        return contractMapper.selectByID(ContractorCode);
    }
    public List<Contract> Transformation(List<Contract> list){
        for(Contract c:list){
            //查询土地类型
            CommonData cDataLandType = commonDataService.getCommonData("PlowlandType", c.getLandType());
            CommonData cDataLandClass = commonDataService.getCommonData("PlowlandClass", c.getLandClass());
            c.setLandTypeName(cDataLandType.getCodeValue());
            c.setLandClassName(cDataLandClass.getCodeValue());
        }
        return list;
    }
}
