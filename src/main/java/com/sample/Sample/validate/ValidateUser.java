package com.sample.Sample.validate;

import org.springframework.util.StringUtils;

import com.sample.Sample.message.ApiMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidateUser {

    public void validateUserId(String userId) throws Exception {
        if (StringUtils.isEmpty(userId)) {
            log.info(ApiMessage.INVALID_USER_ID.getName());
            throw new Exception(ApiMessage.INVALID_USER_ID.getName());
        }
    }

}
