package com.sample.Sample.logic.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.Sample.dao.UserDao;
import com.sample.Sample.entity.UserEntity;
import com.sample.Sample.logic.UserLogic;
import com.sample.Sample.message.ApiMessage;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Component
public class UserLogicImpl implements UserLogic {

    @Autowired
    private UserDao userDao;

    /*
     * (非 Javadoc)
     * @see com.sample.Sample.logic.UserLogic#getAllUser()
     */
    @Override
    public List<UserEntity> getAllUser() throws Exception {
        final List<UserEntity> userList = userDao.getAllUser();

        if (userList.isEmpty()) {
            return Collections.emptyList();
        }

        return userList;
    }

    /*
     * (非 Javadoc)
     * @see com.sample.Sample.logic.UserLogic#getUser(java.lang.String)
     */
    @Override
    public UserEntity getUser(String userId) throws Exception {
        final UserEntity userEntity = userDao.getUser(userId);

        if (userEntity == null) {
            log.info(ApiMessage.USERS_ARE_NOT_EXISTS.getName(), userId);
            throw new Exception(ApiMessage.USERS_ARE_NOT_EXISTS.getName());
        }

        return userEntity;
    }

    /*
     * (非 Javadoc)
     * @see com.sample.Sample.logic.UserLogic#createUser(java.lang.String, java.lang.String, java.lang.Long)
     */
    @Override
    public long createUser(String userId, String userName, Long createdAt) {
        return userDao.createUser(userId, userName, createdAt);
    }

    /*
     * (非 Javadoc)
     * @see com.sample.Sample.logic.UserLogic#deleteUser(java.lang.String)
     */
    @Override
    public long deleteUser(String userId) {
        return userDao.deleteUser(userId);
    }
}
