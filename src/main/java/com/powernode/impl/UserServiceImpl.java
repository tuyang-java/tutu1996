package com.powernode.impl;

import com.powernode.UserDao;
import com.powernode.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.swing.plaf.UIResource;

/**
 * ty
 * 2020/8/18
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void show() {
        System.out.println("service");
        dao.inserAll();
    }
}
