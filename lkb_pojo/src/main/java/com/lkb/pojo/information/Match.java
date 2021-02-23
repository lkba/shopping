package com.lkb.pojo.information;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * match实体类
 * @author Administrator
 *
 */
@Table(name="tb_match")
public class Match implements Serializable{

	@Id
	private Integer id;//id


	

	private String title;//title

	private String hostMain;//举办方

	private String hostTime;//host_time

	private String hostPlace;//host_place

	private String statuss;//是否开始报名 yes   no

	private String isBest;//是否发布 yes   no

	private String period;//第几届比赛

	private String content;//content

	private java.util.Date date;//date

	private java.util.Date releaseTime;//发布时间

	private String peoples;//参加团队数量

	private Integer tid;//团队id

	private Integer cid;//分类id

	private String thumb;//路径id

	private String describes;//照片描述

	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getHostMain() {
		return hostMain;
	}
	public void setHostMain(String hostMain) {
		this.hostMain = hostMain;
	}

	public String getHostTime() {
		return hostTime;
	}
	public void setHostTime(String hostTime) {
		this.hostTime = hostTime;
	}

	public String getHostPlace() {
		return hostPlace;
	}
	public void setHostPlace(String hostPlace) {
		this.hostPlace = hostPlace;
	}

	public String getStatuss() {
		return statuss;
	}
	public void setStatuss(String statuss) {
		this.statuss = statuss;
	}

	public String getIsBest() {
		return isBest;
	}
	public void setIsBest(String isBest) {
		this.isBest = isBest;
	}

	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public java.util.Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(java.util.Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getPeoples() {
		return peoples;
	}
	public void setPeoples(String peoples) {
		this.peoples = peoples;
	}

	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}


	
}
