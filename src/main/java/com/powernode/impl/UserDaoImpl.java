package com.powernode.impl;

import com.powernode.UserDao;
import org.springframework.stereotype.Repository;

/**
 * ty
 * 2020/8/18
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void inserAll() {
        System.out.println("dao");
    }
}
