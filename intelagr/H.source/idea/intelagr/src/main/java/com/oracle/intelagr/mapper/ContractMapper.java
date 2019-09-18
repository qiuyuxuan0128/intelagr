package com.oracle.intelagr.mapper;

import com.oracle.intelagr.entity.Contract;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContractMapper {
    public List<Contract> selectByID( @Param("contractorCode") String contractorCode);
}
