package com.lkb.pojo.teammanager;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * tableSelf实体类
 * @author Administrator
 *
 */
@Table(name="tb_table_self")
public class TableSelf implements Serializable{

	@Id
	private Integer sid;//sid


	

	private String situations;//situation

	private String progress;//progress

	private String plan;//plan

	private String prize;//prize

	private String adminIdea;//admin_idea

	private String hatch;//hatch

	private String departmentIdea;//department_idea

	private Integer selfDateId;//self_date_id

	private String isSelf;//1未自查，0自查

	private String isSub;//0 ：未提交    1：提交

	private java.util.Date date;//date

	private Integer tid;//tid

	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSituations() {
		return situations;
	}
	public void setSituation(String situations) {
		this.situations = situations;
	}

	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getPrize() {
		return prize;
	}
	public void setPrize(String prize) {
		this.prize = prize;
	}

	public String getAdminIdea() {
		return adminIdea;
	}
	public void setAdminIdea(String adminIdea) {
		this.adminIdea = adminIdea;
	}

	public String getHatch() {
		return hatch;
	}
	public void setHatch(String hatch) {
		this.hatch = hatch;
	}

	public String getDepartmentIdea() {
		return departmentIdea;
	}
	public void setDepartmentIdea(String departmentIdea) {
		this.departmentIdea = departmentIdea;
	}

	public Integer getSelfDateId() {
		return selfDateId;
	}
	public void setSelfDateId(Integer selfDateId) {
		this.selfDateId = selfDateId;
	}

	public String getIsSelf() {
		return isSelf;
	}
	public void setIsSelf(String isSelf) {
		this.isSelf = isSelf;
	}

	public String getIsSub() {
		return isSub;
	}
	public void setIsSub(String isSub) {
		this.isSub = isSub;
	}

	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}


	
}
