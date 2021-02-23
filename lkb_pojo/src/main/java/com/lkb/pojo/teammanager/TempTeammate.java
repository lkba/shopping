package com.lkb.pojo.teammanager;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * tempTeammate实体类
 * @author Administrator
 *
 */
@Table(name="tb_temp_teammate")
public class TempTeammate implements Serializable{

	@Id
	private Integer id;//id


	

	private String dname;//dname

	private String dsex;//dsex

	private String ddepartment;//ddepartment

	private String dprofessional;//dprofessional

	private String dphone;//dphone

	private String demail;//demail

	private String tpid;//tpid

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDsex() {
		return dsex;
	}
	public void setDsex(String dsex) {
		this.dsex = dsex;
	}

	public String getDdepartment() {
		return ddepartment;
	}
	public void setDdepartment(String ddepartment) {
		this.ddepartment = ddepartment;
	}

	public String getDprofessional() {
		return dprofessional;
	}
	public void setDprofessional(String dprofessional) {
		this.dprofessional = dprofessional;
	}

	public String getDphone() {
		return dphone;
	}
	public void setDphone(String dphone) {
		this.dphone = dphone;
	}

	public String getDemail() {
		return demail;
	}
	public void setDemail(String demail) {
		this.demail = demail;
	}

	public String getTpid() {
		return tpid;
	}
	public void setTpid(String tpid) {
		this.tpid = tpid;
	}


	
}
