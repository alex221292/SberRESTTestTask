package com.altr.sber.database.init;

import com.altr.sber.database.dao.UserDAO;
import com.altr.sber.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {

    private UserDAO userDAO;

    @Autowired
    public DataInit (UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = userDAO.count();
        if (count == 0) {
            User user1 = new User();
            user1.setName("Aleksei");
            User user2 = new User();
            user2.setName("Aleksander");
            User user3 = new User();
            user3.setName("Ivan");
            userDAO.save(user1);
            userDAO.save(user2);
            userDAO.save(user3);
        }
    }

}
