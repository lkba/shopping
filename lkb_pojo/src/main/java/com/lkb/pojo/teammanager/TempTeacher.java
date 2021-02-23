package com.lkb.pojo.teammanager;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * tempTeacher实体类
 * @author Administrator
 *
 */
@Table(name="tb_temp_teacher")
public class TempTeacher implements Serializable{

	@Id
	private Integer id;//id


	

	private String tname;//导师姓名

	private String tdepartment;//师导系别

	private String position;//师导职务

	private String field;//责负的领域

	private Integer tpid;//临时id

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTdepartment() {
		return tdepartment;
	}
	public void setTdepartment(String tdepartment) {
		this.tdepartment = tdepartment;
	}

	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}

	public Integer getTpid() {
		return tpid;
	}
	public void setTpid(Integer tpid) {
		this.tpid = tpid;
	}


	
}
