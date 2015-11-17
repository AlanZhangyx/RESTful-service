package com.ddup.user.dao;


public interface OauthUsersMapper {
    /** 获取用户ID */
	Long getUserIdByUserCode(String positionId);
}