package com.sample.Sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.Sample.message.ApiMessage;
import com.sample.Sample.model.UserModel;
import com.sample.Sample.service.UserService;
import com.sample.Sample.validate.ValidateUser;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/sample")
    public String index() {
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public ResponseEntity<List<UserModel>> getAllUser() throws Exception {
        log.info(ApiMessage.ENTER_GET_ALL_USER.getName());

        final List<UserModel> userList = userService.getAllUser();

        log.info(ApiMessage.EXIT_GET_ALL_USER.getName());

        return ResponseEntity.ok(userList);
    }

    @ResponseBody
    @RequestMapping(value = "/get/{userId}", method = RequestMethod.GET)
    public ResponseEntity<UserModel> getUser(@PathVariable String userId) throws Exception {
        log.info(ApiMessage.ENTER_GET_USER.getName());

        new ValidateUser().validateUserId(userId);

        final UserModel result = userService.getUser(userId);

        log.info(ApiMessage.EXIT_GET_USER.getName());

        return ResponseEntity.ok(result);
    }
}
