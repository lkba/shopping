package com.lkb.pojo.information;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * picture实体类
 * @author Administrator
 *
 */
@Table(name="tb_picture")
public class Picture implements Serializable{

	@Id
	private Integer nid;//nid


	

	private String title;//title

	private String url;//url

	private java.util.Date time;//time

	private String appendix;//图片的位置

	
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public java.util.Date getTime() {
		return time;
	}
	public void setTime(java.util.Date time) {
		this.time = time;
	}

	public String getAppendix() {
		return appendix;
	}
	public void setAppendix(String appendix) {
		this.appendix = appendix;
	}


	
}
