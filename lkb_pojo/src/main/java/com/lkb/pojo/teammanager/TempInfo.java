package com.lkb.pojo.teammanager;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * tempInfo实体类
 * @author Administrator
 *
 */
@Table(name="tb_temp_info")
public class TempInfo implements Serializable{

	@Id
	private Integer tpid;//tpid


	

	private String team;//team

	private String project;//project

	private String registered;//registered 

	private String money;//money

	private java.util.Date regTime;//reg_time

	private String businessScope;//business_scope

	private String classs;//class

	private String name;//name

	private Integer age;//age

	private String sex;//sex

	private String department;//department

	private String professional;//professional

	private String phone;//phone

	private String email;//email

	private String fund;//fund

	private String areawork;//areawork

	private Integer persons;//persons

	private String form;//form

	private String thinking;//thinking

	private String effect;//effect

	private String abstracts;//abstract

	private String character;//character

	private String feasibility;//feasibility

	private String explain;//explain

	private String prospectus;//prospectus

	private String isAud;//is_aud

	
	public Integer getTpid() {
		return tpid;
	}
	public void setTpid(Integer tpid) {
		this.tpid = tpid;
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

	public String getRegistered() {
		return registered;
	}
	public void setRegistered(String registered) {
		this.registered = registered;
	}

	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}

	public java.util.Date getRegTime() {
		return regTime;
	}
	public void setRegTime(java.util.Date regTime) {
		this.regTime = regTime;
	}

	public String getBusinessScope() {
		return businessScope;
	}
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public String getClasss() {
		return classs;
	}
	public void setClasss(String classs) {
		this.classs = classs;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
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

	public String getFund() {
		return fund;
	}
	public void setFund(String fund) {
		this.fund = fund;
	}

	public String getAreawork() {
		return areawork;
	}
	public void setAreawork(String areawork) {
		this.areawork = areawork;
	}

	public Integer getPersons() {
		return persons;
	}
	public void setPersons(Integer persons) {
		this.persons = persons;
	}

	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}

	public String getThinking() {
		return thinking;
	}
	public void setThinking(String thinking) {
		this.thinking = thinking;
	}

	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getAbstracts() {
		return abstracts;
	}
	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}

	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}

	public String getFeasibility() {
		return feasibility;
	}
	public void setFeasibility(String feasibility) {
		this.feasibility = feasibility;
	}

	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getProspectus() {
		return prospectus;
	}
	public void setProspectus(String prospectus) {
		this.prospectus = prospectus;
	}

	public String getIsAud() {
		return isAud;
	}
	public void setIsAud(String isAud) {
		this.isAud = isAud;
	}


	
}
