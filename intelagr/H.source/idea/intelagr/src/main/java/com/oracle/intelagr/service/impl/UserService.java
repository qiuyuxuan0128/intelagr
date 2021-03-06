package com.oracle.intelagr.service.impl;

import com.oracle.intelagr.common.MD5Util;
import com.oracle.intelagr.common.PageModel;
import com.oracle.intelagr.entity.Function;
import com.oracle.intelagr.entity.Role;
import com.oracle.intelagr.entity.User;
import com.oracle.intelagr.entity.UserRole;
import com.oracle.intelagr.mapper.UserMapper;
import com.oracle.intelagr.mapper.UserRoleMapper;
import com.oracle.intelagr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    public List<User> login(User user) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("userID", user.getUserID());
        map.put("password", MD5Util.getMD5Code(user.getPassword()));
        List<User> list = userMapper.select(map);
        return list;
    }


    public List<Map> getFunction(String userID) {
        User user = userMapper.selectById(userID);
        List<Map> list = new ArrayList<Map>();
        Map moduleMap = new HashMap();
        for(Role role:user.getRoles()){
            for(Function function:role.getFunctions()){
                if(function.getModuleCode()!=null){
                    if(moduleMap.get(function.getModuleCode())==null){
                        Map map = new HashMap();
                        list.add(map);
                        moduleMap.put(function.getModuleCode(),map);
                        map.put("parent",function.getModuleName());
                        List<Function> childList = new ArrayList<Function>();
                        childList.add(function);
                        map.put("child",childList);
                    }else{
                        Map map = (Map)moduleMap.get(function.getModuleCode());
                        List<Function> childList = (List<Function>)map.get("child");
                        childList.add(function);
                    }
                }
            }
        }
        return list;
    }


    public void queryForPage(PageModel pageModel) {
        Map map = (Map)pageModel.getData();
        map.put("index",(pageModel.getPage()-1)*pageModel.getPageSize());
        map.put("pageSize",pageModel.getPageSize());
        List<User> list = userMapper.select(map);
        pageModel.setTotalCount(userMapper.count(map));
        pageModel.setResult(list);
    }


    @Transactional
    public void save(User user) {
        user.setPassword(MD5Util.getMD5Code(user.getPassword()));
        //插入User表
        userMapper.insert(user);
        //插入userRolemap表
        for(Role role:user.getRoles()) {
            //准备UserRole
            UserRole userRole = new UserRole();
            userRole.setUserID(user.getUserID());
            userRole.setRoleCode(role.getRoleCode());
            userRole.setCreateUserId(user.getCreateUserId());
            userRole.setCreateDate(user.getCreateDate());
            userRole.setUpdateDate(user.getUpdateDate());
            userRole.setUpdateUserId(user.getUpdateUserId());
            userRoleMapper.insert(userRole);
        }

    }


    public User selectById(String userID) {
        return userMapper.selectById(userID);
    }


    public void update(User user) {
        userMapper.update(user);
    }



    @Transactional
    public void delete(String userID) {
        User user = userMapper.selectById(userID);
        user.setDeleteFlag("Y");
        userMapper.update(user);
        userRoleMapper.delete(userID);
    }


    @Transactional
    public void delete(String[] userIDs) {
        if(userIDs!=null){
            for(String userID:userIDs){
                User user = userMapper.selectById(userID);
                user.setDeleteFlag("Y");
                userMapper.update(user);
                userRoleMapper.delete(userID);
            }
        }
    }


    public void resetPwd(String userID, String password) {

    }


    public void startUse(String userID) {

    }


    public void endUse(String userID) {

    }
}
