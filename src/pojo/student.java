package pojo;

import java.util.Date;

public class student {
	String name;
	Integer id;
	Date birthday;
	Integer classnumber;
	String sex;
	
	classes c;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getClassnumber() {
		return classnumber;
	}
	public void setClassnumber(Integer classnumber) {
		this.classnumber = classnumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String toString() {
        return "Person [pid=" + id + ", pname=" + name + ", sex=" + sex
                + "]";
	}
}
