package com.lkb.pojo.information;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * matchActor实体类
 * @author Administrator
 *
 */
@Table(name="tb_match_actor")
public class MatchActor implements Serializable{

	@Id
	private Integer maId;//ma_id


	

	private Integer tid;//队团id

	private String tname;//团队名称
	private String mfile;//团队名称


	private Integer mid;//事赛id


	public String getMfile() {
		return mfile;
	}

	public void setMfile(String mfile) {
		this.mfile = mfile;
	}
	public Integer getMaId() {
		return maId;
	}
	public void setMaId(Integer maId) {
		this.maId = maId;
	}

	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}

	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}


	
}
