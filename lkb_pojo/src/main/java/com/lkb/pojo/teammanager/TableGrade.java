package com.lkb.pojo.teammanager;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * tableGrade实体类
 * @author Administrator
 *
 */
@Table(name="tb_table_grade")
public class TableGrade implements Serializable{

	@Id
	private Integer gid;//gid


	

	private String meeting;//meeting

	private String report;//report

	private String checks;//check

	private String studioHea;//studio_hea

	private String publicHea;//public_hea

	private String propagate;//propagate

	private String proSafe;//pro_safe

	private String equipSafe;//equip_safe

	private String operating;//operating

	private String culture;//culture

	private String control;//control

	private String profit;//profit

	private String innovate;//innovate

	private String entAchi;//ent_achi

	private String entOpinion;//ent_opinion

	private String mana;//mana

	private String matchs;//match

	private String totalScore;//total_score

	private String conclusion;//conclusion

	private String judge;//judge

	private java.util.Date date;//date

	private Integer gradeDateId;//评分分类的id

	private String isGrade;//0代表已评审，1代表未评审

	private Integer tid;//tid

	
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getMeeting() {
		return meeting;
	}
	public void setMeeting(String meeting) {
		this.meeting = meeting;
	}

	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}

	public String getChecks() {
		return checks;
	}
	public void setChecks(String checks) {
		this.checks = checks;
	}

	public String getStudioHea() {
		return studioHea;
	}
	public void setStudioHea(String studioHea) {
		this.studioHea = studioHea;
	}

	public String getPublicHea() {
		return publicHea;
	}
	public void setPublicHea(String publicHea) {
		this.publicHea = publicHea;
	}

	public String getPropagate() {
		return propagate;
	}
	public void setPropagate(String propagate) {
		this.propagate = propagate;
	}

	public String getProSafe() {
		return proSafe;
	}
	public void setProSafe(String proSafe) {
		this.proSafe = proSafe;
	}

	public String getEquipSafe() {
		return equipSafe;
	}
	public void setEquipSafe(String equipSafe) {
		this.equipSafe = equipSafe;
	}

	public String getOperating() {
		return operating;
	}
	public void setOperating(String operating) {
		this.operating = operating;
	}

	public String getCulture() {
		return culture;
	}
	public void setCulture(String culture) {
		this.culture = culture;
	}

	public String getControl() {
		return control;
	}
	public void setControl(String control) {
		this.control = control;
	}

	public String getProfit() {
		return profit;
	}
	public void setProfit(String profit) {
		this.profit = profit;
	}

	public String getInnovate() {
		return innovate;
	}
	public void setInnovate(String innovate) {
		this.innovate = innovate;
	}

	public String getEntAchi() {
		return entAchi;
	}
	public void setEntAchi(String entAchi) {
		this.entAchi = entAchi;
	}

	public String getEntOpinion() {
		return entOpinion;
	}
	public void setEntOpinion(String entOpinion) {
		this.entOpinion = entOpinion;
	}

	public String getMana() {
		return mana;
	}
	public void setMana(String mana) {
		this.mana = mana;
	}

	public String getMatchs() {
		return matchs;
	}
	public void setMatchs(String match) {
		this.matchs = matchs;
	}

	public String getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}

	public String getConclusion() {
		return conclusion;
	}
	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public String getJudge() {
		return judge;
	}
	public void setJudge(String judge) {
		this.judge = judge;
	}

	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public Integer getGradeDateId() {
		return gradeDateId;
	}
	public void setGradeDateId(Integer gradeDateId) {
		this.gradeDateId = gradeDateId;
	}

	public String getIsGrade() {
		return isGrade;
	}
	public void setIsGrade(String isGrade) {
		this.isGrade = isGrade;
	}

	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}


	
}
