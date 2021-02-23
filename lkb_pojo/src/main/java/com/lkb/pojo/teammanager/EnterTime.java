package com.lkb.pojo.teammanager;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * enterTime实体类
 * @author Administrator
 *
 */
@Table(name="tb_enter_time")
public class EnterTime implements Serializable{

	@Id
	private Integer id;//入驻时间


	

	private String time;//第几期入驻的团队

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}


	
}
