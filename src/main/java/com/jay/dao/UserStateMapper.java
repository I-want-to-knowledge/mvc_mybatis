package com.jay.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.jay.entities.UserState;

@Mapper
public interface UserStateMapper {
    int insert(@Param("userState") UserState userState);

    int insertSelective(@Param("userState") UserState userState);

    int insertList(@Param("userStates") List<UserState> userStates);

    int updateByPrimaryKeySelective(@Param("userState") UserState userState);

    List<UserState> find();
}
