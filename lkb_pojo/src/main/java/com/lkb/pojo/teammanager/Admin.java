package com.lkb.pojo.teammanager;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * admin实体类
 * @author Administrator
 *
 */
@Table(name="tb_admin")
public class Admin implements Serializable{

	@Id
	private Integer aid;//aid


	

	private String username;//username

	private String password;//password

	private String name;//name

	private String email;//email

	private String phone;//phone

	
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}


	
}
