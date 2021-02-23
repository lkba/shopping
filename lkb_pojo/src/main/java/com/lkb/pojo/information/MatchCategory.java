package com.lkb.pojo.information;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * matchCategory实体类
 * @author Administrator
 *
 */
@Table(name="tb_match_category")
public class MatchCategory implements Serializable{

	@Id
	private Integer cid;//cid


	

	private String cname;//分类名称

	private Integer pid;//pid

	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}


	
}
