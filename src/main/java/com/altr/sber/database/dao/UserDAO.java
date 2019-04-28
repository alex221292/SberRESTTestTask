package com.altr.sber.database.dao;

import com.altr.sber.database.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UserDAO extends CrudRepository<User, BigInteger> {
}
