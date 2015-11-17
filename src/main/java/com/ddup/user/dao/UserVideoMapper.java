package com.ddup.user.dao;

import com.ddup.user.dao.model.UserVideo;

public interface UserVideoMapper {
    int deleteByPrimaryKey(Long videoId);

    int insert(UserVideo record);

    int insertSelective(UserVideo record);

    UserVideo selectByPrimaryKey(Long videoId);

    int updateByPrimaryKeySelective(UserVideo record);

    int updateByPrimaryKey(UserVideo record);
}