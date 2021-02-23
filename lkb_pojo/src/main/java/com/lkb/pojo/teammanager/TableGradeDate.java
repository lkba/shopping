package com.lkb.pojo.teammanager;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * tableGradeDate实体类
 * @author Administrator
 *
 */
@Table(name="tb_table_grade_date")
public class TableGradeDate implements Serializable{

	@Id
	private Integer id;//评分表时间分类


	

	private Integer tid;//tid

	private java.util.Date gradeDate;//grade_date

	
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

	public java.util.Date getGradeDate() {
		return gradeDate;
	}
	public void setGradeDate(java.util.Date gradeDate) {
		this.gradeDate = gradeDate;
	}


	
}
