package Mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pojo.student;

public interface StudentMapper {
	
	    @Insert(" insert into student(id,name,sex,birth,classnumber) values(#{id},#{name},#{sex},#{birthday},#{classnumber})")
	    public int add(student s);
	     
	    @Select("select * from student where id = #{id}")
	    public student getStudent(int id);
	     
	    @Update(" update student set name=#{name},sex=#{sex},birth=#{birth},classnumber=#{classnumber} where id = #{id}")
	    public int updateStudent(student s);
	     
	    @Delete("delete from student where id=#{id}")
	    public int deleteStudent(int pid);
}
