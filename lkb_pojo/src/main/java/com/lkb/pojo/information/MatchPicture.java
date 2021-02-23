package com.lkb.pojo.information;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * matchPicture实体类
 * @author Administrator
 *
 */
@Table(name="tb_match_picture")
public class MatchPicture implements Serializable{

	@Id
	private Integer pid;//pid


	

	private String thumb;//路径id

	private String describes;//照片描述

	private Integer mid;//赛事的id

	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}

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

	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}


	
}
