package com.sample.Sample.service;

import java.util.List;

import com.sample.Sample.model.UserModel;

public interface UserService {

    public List<UserModel> getAllUser() throws Exception;

    public UserModel getUser(String userId) throws Exception;

    public long createUser(String userId, String userName) throws Exception;

    public long deleteUser(String userId);
}
