package com.lkb.pojo.teammanager;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * tableOut实体类
 * @author Administrator
 *
 */
@Table(name="tb_table_out")
public class TableOut implements Serializable{

	@Id
	private Integer oid;//oid


	

	private String baseStiu;//base_stiu

	private String outReason;//out_reason

	private String idea;//idea

	private String proposer;//proposer

	private java.util.Date outdate;//outdate

	private String workarea;//workarea

	private String account;//account

	private String health;//health

	private String equip;//equip

	private String adminIdea;//admin_idea

	private java.util.Date edate;//edate

	private String isOut;//0代表退出，1代表未退出

	private String isSub;//0:未提交  1:提交

	private String goback;//1退回

	private Integer tid;//tid

	
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getBaseStiu() {
		return baseStiu;
	}
	public void setBaseStiu(String baseStiu) {
		this.baseStiu = baseStiu;
	}

	public String getOutReason() {
		return outReason;
	}
	public void setOutReason(String outReason) {
		this.outReason = outReason;
	}

	public String getIdea() {
		return idea;
	}
	public void setIdea(String idea) {
		this.idea = idea;
	}

	public String getProposer() {
		return proposer;
	}
	public void setProposer(String proposer) {
		this.proposer = proposer;
	}

	public java.util.Date getOutdate() {
		return outdate;
	}
	public void setOutdate(java.util.Date outdate) {
		this.outdate = outdate;
	}

	public String getWorkarea() {
		return workarea;
	}
	public void setWorkarea(String workarea) {
		this.workarea = workarea;
	}

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}

	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}

	public String getEquip() {
		return equip;
	}
	public void setEquip(String equip) {
		this.equip = equip;
	}

	public String getAdminIdea() {
		return adminIdea;
	}
	public void setAdminIdea(String adminIdea) {
		this.adminIdea = adminIdea;
	}

	public java.util.Date getEdate() {
		return edate;
	}
	public void setEdate(java.util.Date edate) {
		this.edate = edate;
	}

	public String getIsOut() {
		return isOut;
	}
	public void setIsOut(String isOut) {
		this.isOut = isOut;
	}

	public String getIsSub() {
		return isSub;
	}
	public void setIsSub(String isSub) {
		this.isSub = isSub;
	}

	public String getGoback() {
		return goback;
	}
	public void setGoback(String goback) {
		this.goback = goback;
	}

	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}


	
}
