package test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import pojo.student;

public class mytest {
	SqlSession session;
    
    @Before
    public void beforeLoadXML(){
        //加载 mybatis 配置文件
        InputStream inputStream = mytest.class.
                getClassLoader().getResourceAsStream("mybatis-configuration.xml");
        //构建sqlSession的工厂
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //根据 sqlSessionFactory 产生 session
        session = sqlSessionFactory.openSession();
    }
    
    @Test
    public void testgetAllStudents(){
    	String statement = "studentMapper.getStudents";
    	List<student> s = session.selectList(statement);
    	System.out.println(s);
    }
    
    @Test
    public void testDeleteStudent(){
    	testgetAllStudents();
    	String statement = "studentMapper.deleteStudents";
    	session.delete(statement,201402003);
    	session.commit();
    	testgetAllStudents();
        session.close();    	
    }
  /*  //根据 id 查询 student表中的数据
   @Test
    public void testSelectById(){
        //这个字符串有 studentMapper.xml 文件中 两个部分构成
        //<mapper namespace="studentMapper"> 的 namespace 的值
        //<select id="selectPersonById" > id 值
        String statement = "studentMapper"+".selectStudentById";
        student p = session.selectOne(statement, 201401001);
        System.out.println(p);
        session.close();
    }
    
   //向 person 表插入一条数据
   @Test
   public void addStudent(){
       String statement = "studentMapper.addStudent";
       student p = new student(); 
       p.setId(120160903);
       p.setName("add");
       p.setClassnumber(10001);
       session.insert(statement, p);
       session.commit();
       session.close();
   } */
    //查询person 表所有数据
     /*@Test
    public void testGetAllPerson(){
        String statement = "studentMapper.getAllStudent";
        List<student> listPerson = session.selectList(statement);
        System.out.println(listPerson);
        session.close();
    }
     
    //根据id更新数据
    @Test
    public void updateById(){
        String statement = "studentMapper。updateStudentById";
        student p = new student();
        p.setId(1);
        p.setName("aaa");
        session.update(statement, p);
        session.commit();
        session.close();
    }*/
     
   
     
    //根据 pid 删除person 表中的数据
   /* @Test
    public void deletePersonById(){
        String statement = "studentMapper.deleteStudentById";
        session.delete(statement, 1);
        session.commit();
        session.close();
         
    }*/
}
