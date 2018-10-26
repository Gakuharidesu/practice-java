package com.sample.Sample.logic;

import java.util.List;

import com.sample.Sample.entity.UserEntity;

public interface UserLogic {

    public List<UserEntity> getAllUser() throws Exception;

    public UserEntity getUser(String userId) throws Exception;

    public long createUser(String userId, String userName, Long createdAt);

    public long deleteUser(String userId);
}
