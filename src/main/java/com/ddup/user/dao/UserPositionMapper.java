package com.ddup.user.dao;

import java.util.Map;

import com.ddup.user.dao.model.UserPosition;

public interface UserPositionMapper {
    int deleteByPrimaryKey(Long positionId);

    int insert(UserPosition record);

    int insertSelective(UserPosition record);

    UserPosition selectByPrimaryKey(Long positionId);

    int updateByPrimaryKeySelective(UserPosition record);

    int updateByPrimaryKey(UserPosition record);
    // 用户上传位置
    int uploadUserPosition(Map<String,Object> map);
}