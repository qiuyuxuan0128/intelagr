package com.oracle.intelagr.service;

import com.oracle.intelagr.entity.Contract;
import com.oracle.intelagr.entity.GeneLandReg;
import com.oracle.intelagr.entity.Peasant;

import java.util.List;
import java.util.Map;

public interface IGeneLandRegService {
    public GeneLandReg queryOne(Map map);
    public List<Contract> selectByID(String ContractorCode);
    public List<Peasant> queryPeasant(Map map);
    public List<Contract> Transformation(List<Contract> list);
}
