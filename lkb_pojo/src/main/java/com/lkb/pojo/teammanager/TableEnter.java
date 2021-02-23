package com.lkb.pojo.teammanager;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * tableEnter实体类
 * @author Administrator
 *
 */
@Table(name="tb_table_enter")
public class TableEnter implements Serializable{

	@Id
	private Integer eid;//eid


	

	private String money;//money

	private String areawork;//areawork '实践园','创新创业学院'

	private String enterTime;//第几期入驻

	private Integer persons;//persons

	private String form;//form

	private String thinking;//thinking

	private String effect;//effect

	private String abstracts;//abstracts

	private String characters;//character

	private String feasibility;//feasibility

	private String explains;//explain

	private String prospectus;//prospectus

	private String datas;//data

	private String departmentIdea;//department_idea

	private String date;//date

	private Integer tid;//tid

	
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}

	public String getAreawork() {
		return areawork;
	}
	public void setAreawork(String areawork) {
		this.areawork = areawork;
	}

	public String getEnterTime() {
		return enterTime;
	}
	public void setEnterTime(String enterTime) {
		this.enterTime = enterTime;
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

	public String getCharacters() {
		return characters;
	}
	public void setCharacters(String characters) {
		this.characters = characters;
	}

	public String getFeasibility() {
		return feasibility;
	}
	public void setFeasibility(String feasibility) {
		this.feasibility = feasibility;
	}

	public String getExplains() {
		return explains;
	}
	public void setExplains(String explains) {
		this.explains = explains;
	}

	public String getProspectus() {
		return prospectus;
	}
	public void setProspectus(String prospectus) {
		this.prospectus = prospectus;
	}

	public String getDatas() {
		return datas;
	}
	public void setDatas(String data) {
		this.datas = datas;
	}

	public String getDepartmentIdea() {
		return departmentIdea;
	}
	public void setDepartmentIdea(String departmentIdea) {
		this.departmentIdea = departmentIdea;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}


	
}
