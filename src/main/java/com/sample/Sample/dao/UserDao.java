package com.sample.Sample.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.Sample.entity.UserEntity;

@Mapper
public interface UserDao {

    public List<UserEntity> getAllUser();

    public UserEntity getUser(String userId);

    public long createUser(String userId, String userName, long createdAt);

    public long updateUser(String userId, String userName, long updatedAt);

    public long deleteUser(String userId);
}
