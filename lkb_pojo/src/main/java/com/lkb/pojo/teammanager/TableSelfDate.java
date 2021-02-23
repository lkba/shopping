package com.lkb.pojo.teammanager;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * tableSelfDate实体类
 * @author Administrator
 *
 */
@Table(name="tb_table_self_date")
public class TableSelfDate implements Serializable{

	@Id
	private Integer id;//评分表时间分类


	

	private Integer tid;//tid

	private java.util.Date selfDate;//self_date

	
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

	public java.util.Date getSelfDate() {
		return selfDate;
	}
	public void setSelfDate(java.util.Date selfDate) {
		this.selfDate = selfDate;
	}


	
}
