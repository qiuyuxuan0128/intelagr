package com.oracle.intelagr.service.impl;

import com.oracle.intelagr.entity.GeneLandRegD;
import com.oracle.intelagr.mapper.GeneLandRegDMapper;
import com.oracle.intelagr.service.IGeneLandRegDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneLandRegDService implements IGeneLandRegDService {
   @Autowired
   private GeneLandRegDMapper geneLandRegDMapper;
    public List<GeneLandRegD> selectAll() {
        return geneLandRegDMapper.selectAll();
    }
}
