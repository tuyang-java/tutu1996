package com.powernode.service;

import com.powernode.reflict.Colum;
import com.powernode.reflict.Table;

/**
 * ty
 * 2020/9/16
 */
@Table(Value = "student")
public class Student {
    @Colum(value = "sid",isPK = true)
    private String id;

    @Colum(value="sname")
    private String sname;

    @Colum(value="saddress")
    private String saddress;






    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", sname='" + sname + '\'' +
                ", saddress='" + saddress + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }
}
