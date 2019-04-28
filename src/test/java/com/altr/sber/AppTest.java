package com.altr.sber;

import static org.junit.Assert.assertTrue;

import com.altr.sber.database.dao.UserDAO;
import com.altr.sber.database.entity.User;
import com.altr.sber.web.pojo.build.ResponseBuilder;
import com.altr.sber.web.pojo.build.UserResponseBuilder;
import com.altr.sber.web.pojo.response.UserResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AppTest 
{
    private User user;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserDAO userDAO;

    @Before
    public void setUp(){
        user = new User();
        user.setName("Test");
    }

    @Test
    public void userResponseBuilderTest() {
        ResponseBuilder builder = new UserResponseBuilder(user,"TEST STATUS", 900);
        UserResponse response = (UserResponse) builder.build();
        Assert.assertTrue("Test".equals(response.getUserName()));
    }
}
