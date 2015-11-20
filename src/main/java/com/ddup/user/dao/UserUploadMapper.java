package com.ddup.user.dao;

import com.ddup.user.dao.model.UserUpload;

public interface UserUploadMapper {
    int deleteByPrimaryKey(Long uploadId);

    int insert(UserUpload record);

    int insertSelective(UserUpload record);

    UserUpload selectByPrimaryKey(Long uploadId);

    int updateByPrimaryKeySelective(UserUpload record);

    int updateByPrimaryKey(UserUpload record);
}