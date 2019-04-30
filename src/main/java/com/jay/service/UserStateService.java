package com.jay.service;

import java.util.List;
import com.jay.entities.UserState;
public interface UserStateService{

    int insert(UserState userState);

    int insertSelective(UserState userState);

    int insertList(List<UserState> userStates);

    int updateByPrimaryKeySelective(UserState userState);

    List<UserState> find();
}
