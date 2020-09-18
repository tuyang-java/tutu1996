package com.powernode.reflict;

/**
 * ty
 * 2020/9/15
 */
@Table(Value = "user")
public class User {
    @Colum(value = "name",isPK = false)
    private String name;

    @Colum(value="pwd",isPK = false)
    private String pwd;


    //无参构造
    public User(){}

    //有参构造
    public User(String name,String pwd){
        this.name=name;
        this.pwd=pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
