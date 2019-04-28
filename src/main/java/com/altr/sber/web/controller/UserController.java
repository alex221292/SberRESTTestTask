package com.altr.sber.web.controller;

import com.altr.sber.database.dao.UserDAO;
import com.altr.sber.database.entity.User;
import com.altr.sber.web.pojo.build.ResponseBuilder;
import com.altr.sber.web.pojo.request.UserRequest;
import com.altr.sber.web.pojo.response.UserResponse;
import com.altr.sber.web.pojo.build.UserResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final String sharedKey = "AUTH123456";

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;
    private static final int DATA_DOES_NOT_EXIST = 103;

    @Autowired
    private UserDAO userDAO;

    @GetMapping
    public UserResponse showStatus() {
        return new UserResponse(SUCCESS_STATUS, 1);
    }

    @PostMapping("/get")
    public UserResponse get(@RequestParam(value = "key") String key, @RequestBody UserRequest request) {
        final UserResponse response;
        ResponseBuilder builder;
        if (sharedKey.equals(key)) {
            BigInteger userId = request.getUserId();
            Optional<User> optionalUser = userDAO.findById(userId);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                builder = new UserResponseBuilder(user, SUCCESS_STATUS, CODE_SUCCESS);
                response = (UserResponse) builder.build();
            } else {
                response = new UserResponse(ERROR_STATUS, DATA_DOES_NOT_EXIST);
            }
        } else {
            response = new UserResponse(ERROR_STATUS, AUTH_FAILURE);
        }
        return response;
    }

}
