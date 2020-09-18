package com.powernode;

import com.powernode.impl.Controller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.security.Provider;

/**
 * Hello world!
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class App 
{
    /*public static void main( String[] args ) {

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        Controller controller=(Controller) applicationContext.getBean("controller");
        controller.show();

    }*/

    @Autowired
    private UserService userService;
    @Test
    public void test(){
        userService.show();
    }
}
