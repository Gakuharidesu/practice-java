package com.sample.Sample.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.Sample.entity.UserEntity;
import com.sample.Sample.logic.UserLogic;
import com.sample.Sample.model.UserModel;
import com.sample.Sample.service.UserService;

import lombok.Setter;

@Setter
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserLogic userLogic;

    /*
     * (非 Javadoc)
     * @see com.sample.Sample.service.UserService#getUserAll()
     */
    @Override
    public List<UserModel> getAllUser() throws Exception {
        final List<UserEntity> userList = userLogic.getAllUser();

        return userList.stream()
                .map(user -> convertUserEntity(user))
                .collect(Collectors.toList());
    }

    /*
     * (非 Javadoc)
     * @see com.sample.Sample.service.UserService#getUser(java.lang.String)
     */
    @Override
    public UserModel getUser(String userId) throws Exception {
        final UserEntity userEntity = userLogic.getUser(userId);

        return convertUserEntity(userEntity);
    }

    /**
     * DBから取得したユーザー情報を画面表示用に変換する
     *
     * @param entity DBから取得したユーザ情報
     * @return UserModelを返す
     */
    private UserModel convertUserEntity(UserEntity entity) {
        final String userId = entity.getUserId();
        final String userName = entity.getUserName();
        final String createdAt = entity.getCreatedAt().toString();
        final String updatedAt = entity.getUpdatedAt().toString();

        return UserModel.builder()
                .userId(userId)
                .userName(userName)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }

    /*
     * (非 Javadoc)
     * @see com.sample.Sample.service.UserService#createUser(java.lang.String, java.lang.String)
     */
    @Override
    public long createUser(String userId, String userName) throws Exception {
        final long createdAt = System.currentTimeMillis();

        return userLogic.createUser(userId, userName, createdAt);
    }

    /*
     * (非 Javadoc)
     * @see com.sample.Sample.service.UserService#deleteUser(java.lang.String)
     */
    @Override
    public long deleteUser(String userId) {
        return userLogic.deleteUser(userId);
    }
}
