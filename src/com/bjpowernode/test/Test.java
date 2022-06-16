package com.bjpowernode.test;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        //输入流
        InputStream inputStream = null;
        try{
            //通过加载mybatis的主配置文件mybatis-config.xml，创建输入流对象
            inputStream = Resources.getResourceAsStream(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        //未来的所有操作 都是使用SqlSession对象 session来完成
        //例如 增删改查，处理事务等等，统一使用session对象完成
        SqlSession session = sqlSessionFactory.openSession();

        /*
        *
        *   1、需求：根据id查单条
        *
        *          如果取得的是单条记录，我们调用selectOne()方法
        *          参数1：根据命名空间.sqlId的形式找到我们需要的sql语句
        *          参数2：我们要为sql语句中传递的参数
        *
        * */

//        Student s = session.selectOne("test1.getById","A0001");
//        System.out.println(s);
//        session.close();

        /*
            2、查询表中所有的记录
         */

        /*
        List<Student> sList = session.selectList("test1.getAll");
        for (Student s:sList) {
            System.out.println(s);
        }
        session.close();
        */

        /*
            3、添加操作
         */
        /*

        Student s = new Student();
        s.setId("A0006");
        s.setName("cxk");
        s.setAge(23);
        session.insert("test1.save",s);
        session.commit(); // mybatis 默认 手动提交事务。 不提交事务的话，无法成功添加
        session.close();

        */

        /*

            4、修改操作

         */
        /*
        Student s = new Student();
        s.setName("cxk1");
        s.setAge(24);
        s.setId("A0006");
        session.update("test1.update",s);
        session.commit();
        session.close();
         */

        /*
            5、删除操作
         */
        session.delete("test1.delete","A0001");
        session.commit();
        session.close();

    }
}
