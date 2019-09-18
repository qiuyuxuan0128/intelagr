package com.oracle.intelagr.mapper;

import com.oracle.intelagr.entity.Peasant;

import java.util.List;
import java.util.Map;

public interface PeasantMapper {
    public List<Peasant> selectAll();
    public List<Peasant> selectById(Map map);
}
