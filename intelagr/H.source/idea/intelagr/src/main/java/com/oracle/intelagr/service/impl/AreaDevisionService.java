package com.oracle.intelagr.service.impl;

import com.oracle.intelagr.entity.AreaDevision;
import com.oracle.intelagr.entity.Peasant;
import com.oracle.intelagr.mapper.AreaDevisionMapper;
import com.oracle.intelagr.service.IAreaDevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AreaDevisionService implements IAreaDevisionService {
    @Autowired
    private AreaDevisionMapper areaDevisionMapper;
    public AreaDevision selectByMap(Peasant peasant) {
        Map<String,Object> map =new HashMap<String, Object>();
        map.put("TownCode",peasant.getTownCode());
        map.put("CountryCode",peasant.getCountryCode());
        return areaDevisionMapper.selectByMap(map);
    }
}
