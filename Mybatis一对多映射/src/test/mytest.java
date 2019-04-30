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
        //���� mybatis �����ļ�
        InputStream inputStream = mytest.class.
                getClassLoader().getResourceAsStream("mybatis-configuration.xml");
        //����sqlSession�Ĺ���
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //���� sqlSessionFactory ���� session
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
  /*  //���� id ��ѯ student���е�����
   @Test
    public void testSelectById(){
        //����ַ����� studentMapper.xml �ļ��� �������ֹ���
        //<mapper namespace="studentMapper"> �� namespace ��ֵ
        //<select id="selectPersonById" > id ֵ
        String statement = "studentMapper"+".selectStudentById";
        student p = session.selectOne(statement, 201401001);
        System.out.println(p);
        session.close();
    }
    
   //�� person �����һ������
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
    //��ѯperson ����������
     /*@Test
    public void testGetAllPerson(){
        String statement = "studentMapper.getAllStudent";
        List<student> listPerson = session.selectList(statement);
        System.out.println(listPerson);
        session.close();
    }
     
    //����id��������
    @Test
    public void updateById(){
        String statement = "studentMapper��updateStudentById";
        student p = new student();
        p.setId(1);
        p.setName("aaa");
        session.update(statement, p);
        session.commit();
        session.close();
    }*/
     
   
     
    //���� pid ɾ��person ���е�����
   /* @Test
    public void deletePersonById(){
        String statement = "studentMapper.deleteStudentById";
        session.delete(statement, 1);
        session.commit();
        session.close();
         
    }*/
}
