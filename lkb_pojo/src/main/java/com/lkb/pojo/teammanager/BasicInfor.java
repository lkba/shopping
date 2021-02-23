package com.lkb.pojo.teammanager;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * basicInfor实体类
 * @author Administrator
 *
 */
@Table(name="tb_basic_infor")
public class BasicInfor implements Serializable{

	@Id
	private Integer id;//id


	

	private String logo;//logo

	private String team;//team

	private String project;//project

	private java.util.Date inTime;//in_time

	private String registered;//registered 是否注册   是   否

	private String reMoney;//教师备注注册金额

	private String money;//money

	private String regTime;//reg_time

	private String businessScope;//business_scope

	private String class_por;//class  '产品开发类','技术服务类','商业服务类'

	private Integer tid;//tid

	private String property;//1 :专业创业 2:软件开发与服务 3:专业创业与软件开发与服务

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}

	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}

	public java.util.Date getInTime() {

		return inTime;
	}
	public void setInTime(java.util.Date inTime) {
		this.inTime = inTime;
	}

	public String getRegistered() {
		return registered;
	}
	public void setRegistered(String registered) {
		this.registered = registered;
	}

	public String getReMoney() {
		return reMoney;
	}
	public void setReMoney(String reMoney) {
		this.reMoney = reMoney;
	}

	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}

	public String getRegTime() {

		return regTime;
	}
	public void setRegTime(String regTime) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//
//			regTime=sdf.parse(sdf.format(regTime));
//		}catch (ParseException e){
//			e.printStackTrace();
//		}
		this.regTime = regTime;
	}

	public String getBusinessScope() {
		return businessScope;
	}
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public String getClass_por() {
		return class_por;
	}
	public void setClass_por(String class_por) {
		this.class_por = class_por;
	}

	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}


	
}
