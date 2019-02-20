package com.jay.service;

import com.jay.dao.UserStateMapper;
import com.jay.entities.UserState;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserStateServiceImpl implements UserStateService{

    @Resource
    private UserStateMapper userStateMapper;

    @Override
    public int insert(UserState userState){
        System.out.println("进入服务层");
        return userStateMapper.insert(userState);
    }

    @Override
    public int insertSelective(UserState userState){
        return userStateMapper.insertSelective(userState);
    }

    @Override
    public int insertList(List<UserState> userStates){
        return userStateMapper.insertList(userStates);
    }

    @Override
    public int updateByPrimaryKeySelective(UserState userState){
        return userStateMapper.updateByPrimaryKeySelective(userState);
    }
}
