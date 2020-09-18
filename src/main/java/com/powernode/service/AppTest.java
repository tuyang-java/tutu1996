package com.powernode.service;

import java.util.List;

/**
 * ty
 * 2020/9/15
 */
public class AppTest {
    public static void main(String[] args) {

        try {
            CURDUtils.deleteStuent(Student.class,1);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }
}
