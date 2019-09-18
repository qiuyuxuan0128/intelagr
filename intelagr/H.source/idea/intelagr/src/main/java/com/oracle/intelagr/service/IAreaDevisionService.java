package com.oracle.intelagr.service;

import com.oracle.intelagr.entity.AreaDevision;
import com.oracle.intelagr.entity.Peasant;

public interface IAreaDevisionService {
    public AreaDevision selectByMap(Peasant peasant);
}
