package com.lkb.pojo.teammanager;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * remarks实体类
 * @author Administrator
 *
 */
@Table(name="tb_remarks")
public class Remarks implements Serializable{

	@Id
	private Integer rid;//rid


	

	private String rteam;//入驻团队

	private String totleTeam;//团队总人数

	private String rcompany;//已注册公司

	private String noCompany;//两创团队在位情况未注册公司

	private String yesCompany;//两创团队在位情况已注册公司

	private String allCompany;//两创团队在位情况

	private String outTeam1;//因项目停止、团队解散等原因而退出

	private String outTeam2;//已注册公司外出发展的

	private String outTeam3;//其他 

	private String outTeamAll;//退出情况

	private String regCompany1;//注册公司仍在位

	private String regCompany2;//注册公司不在位

	private String regCompany3;//注册公司，但项目停止

	private String regCompany4;//公司注销

	private String regCompanyAll;//注册公司情况

	private String proEnt;//相关专业创业

	private String soft;//相关专业创业

	private String softPro;//相关专业创业-相关专业创业

	
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRteam() {
		return rteam;
	}
	public void setRteam(String rteam) {
		this.rteam = rteam;
	}

	public String getTotleTeam() {
		return totleTeam;
	}
	public void setTotleTeam(String totleTeam) {
		this.totleTeam = totleTeam;
	}

	public String getRcompany() {
		return rcompany;
	}
	public void setRcompany(String rcompany) {
		this.rcompany = rcompany;
	}

	public String getNoCompany() {
		return noCompany;
	}
	public void setNoCompany(String noCompany) {
		this.noCompany = noCompany;
	}

	public String getYesCompany() {
		return yesCompany;
	}
	public void setYesCompany(String yesCompany) {
		this.yesCompany = yesCompany;
	}

	public String getAllCompany() {
		return allCompany;
	}
	public void setAllCompany(String allCompany) {
		this.allCompany = allCompany;
	}

	public String getOutTeam1() {
		return outTeam1;
	}
	public void setOutTeam1(String outTeam1) {
		this.outTeam1 = outTeam1;
	}

	public String getOutTeam2() {
		return outTeam2;
	}
	public void setOutTeam2(String outTeam2) {
		this.outTeam2 = outTeam2;
	}

	public String getOutTeam3() {
		return outTeam3;
	}
	public void setOutTeam3(String outTeam3) {
		this.outTeam3 = outTeam3;
	}

	public String getOutTeamAll() {
		return outTeamAll;
	}
	public void setOutTeamAll(String outTeamAll) {
		this.outTeamAll = outTeamAll;
	}

	public String getRegCompany1() {
		return regCompany1;
	}
	public void setRegCompany1(String regCompany1) {
		this.regCompany1 = regCompany1;
	}

	public String getRegCompany2() {
		return regCompany2;
	}
	public void setRegCompany2(String regCompany2) {
		this.regCompany2 = regCompany2;
	}

	public String getRegCompany3() {
		return regCompany3;
	}
	public void setRegCompany3(String regCompany3) {
		this.regCompany3 = regCompany3;
	}

	public String getRegCompany4() {
		return regCompany4;
	}
	public void setRegCompany4(String regCompany4) {
		this.regCompany4 = regCompany4;
	}

	public String getRegCompanyAll() {
		return regCompanyAll;
	}
	public void setRegCompanyAll(String regCompanyAll) {
		this.regCompanyAll = regCompanyAll;
	}

	public String getProEnt() {
		return proEnt;
	}
	public void setProEnt(String proEnt) {
		this.proEnt = proEnt;
	}

	public String getSoft() {
		return soft;
	}
	public void setSoft(String soft) {
		this.soft = soft;
	}

	public String getSoftPro() {
		return softPro;
	}
	public void setSoftPro(String softPro) {
		this.softPro = softPro;
	}


	
}
