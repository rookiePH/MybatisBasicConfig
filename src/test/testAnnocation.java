package test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import Mapper.StudentMapper;
import pojo.student;

public class testAnnocation {

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
    public void testAnnocation() {
    	//session.getConfiguration().addMapper(StudentMapper.class);
    	StudentMapper mapper = session.getMapper(StudentMapper.class);
    	student s = new student();
    	s.setId(3);
    	s.setName("youoh");
    	mapper.add(s);
    	System.out.println(mapper.getStudent(1));
    	session.commit();
    	session.close();
	}
}
