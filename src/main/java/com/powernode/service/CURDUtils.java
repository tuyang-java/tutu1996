package com.powernode.service;

import com.powernode.reflict.Colum;
import com.powernode.reflict.Table;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ty
 * 2020/9/16
 */
public class CURDUtils {
    private static PreparedStatement ps;
    private static ResultSet rs;
    private  static Connection connection = jdbcUtils.getConnection();


    //删除
    public static<T> void deleteStuent(Class<T> calzz,int sid) throws NoSuchFieldException {
        //构造删除语句
        StringBuffer sb=new StringBuffer("delete from ");
        sb.append(getTableName(calzz)).append(" where ");
        Field field = calzz.getDeclaredField("id");
        Colum annotation = field.getAnnotation(Colum.class);
        String value = annotation.value();
        sb.append(value).append(" =?");
        String sql=sb.toString();
        System.out.println(sql);

        try {
            ps = connection.prepareStatement(sql);
            ps.setObject(1, sid);
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //查找
    public static <T> List<T> selectStudent(Class<T> calzz){

        StringBuffer sb=new StringBuffer("select * from ");
        sb.append(getTableName(calzz));
        String  sql=sb.toString();
        List<T>list=new ArrayList<>();
        try {
            ps=connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                Constructor<T> constructor = calzz.getConstructor(null);
                T t = constructor.newInstance(null);
                Field[] fields = calzz.getDeclaredFields();
                for (Field field : fields) {
                    String values = field.getAnnotation(Colum.class).value();
                    Object value = rs.getObject(values);
                    String fieldName = field.getName();
                    Class<?> type = field.getType();
                    Method set = getSet(calzz, fieldName, type);


                    set.invoke(t,value);
                }

                list.add(t);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }







    //得到表的名称
    public static<T>  String getTableName(Class<T> calzz){
        Table annotation = calzz.getAnnotation(Table.class);
        String value = annotation.Value();
        return value;
    }

    //得到student的set方法
    public static<T> Method getSet(Class<T>clazz,String fieldName,Class<?>type) throws NoSuchMethodException {
        String name="set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
        System.out.println(name);
        Method declaredMethod = clazz.getDeclaredMethod(name, type);
        return declaredMethod;
    }

}
