package com.lkb.pojo.information;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * notice实体类
 * @author Administrator
 *
 */
@Table(name="tb_notice")
public class Notice implements Serializable{

	@Id
	private Integer nid;//nid


	

	private String ntitle;//ntitle

	private String ncontent;//ncontent

	private java.util.Date ntime;//ntime

	private String appendix;//附带文件

	
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	public java.util.Date getNtime() {
		return ntime;
	}
	public void setNtime(java.util.Date ntime) {
		this.ntime = ntime;
	}

	public String getAppendix() {
		return appendix;
	}
	public void setAppendix(String appendix) {
		this.appendix = appendix;
	}


	
}
