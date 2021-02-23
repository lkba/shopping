package com.lkb.pojo.information;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * newsManypop实体类
 * @author Administrator
 *
 */
@Table(name="tb_news_manypop")
public class NewsManypop implements Serializable{

	@Id
	private Integer id;//发信息给多个团队


	

	private Integer tid;//tid

	private String isRead;//1：没读；0：读取

	private Integer nid;//新闻id

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getIsRead() {
		return isRead;
	}
	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}


	
}
