package com.lkb.pojo.teammanager;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * teammate实体类
 * @author Administrator
 *
 */
@Table(name="tb_teammate")
public class Teammate implements Serializable{

	@Id
	private Integer id;//id


	

	private String name;//name

	private String sex;//sex

	private String department;//department

	private String professional;//professional

	private String phone;//phone

	private String email;//email

	private String tid;//tid

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}


	
}
