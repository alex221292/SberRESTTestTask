package com.altr.sber.web.pojo.build;

import com.altr.sber.database.entity.User;
import com.altr.sber.web.pojo.response.UserResponse;

public class UserResponseBuilder extends AbstractResponseBuilder implements ResponseBuilder {

    public UserResponseBuilder(Object user, String status, int code) {
        super(user, status, code);
    }

    public UserResponseBuilder(String status, int code) {
        super(status, code);
    }

    public UserResponse build() {
        UserResponse userResponse = new UserResponse(this.status, this.code);
        if (this.input != null && input instanceof User) {
            User user = (User) input;
            userResponse.setUserId(user.getId());
            userResponse.setUserName(user.getName());
        }
        return userResponse;
    }

}
