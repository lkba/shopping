package com.lkb.pojo.information;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * newsMany实体类
 * @author Administrator
 *
 */
@Table(name="tb_news_many")
public class NewsMany implements Serializable{

	@Id
	private Integer id;//发信息给多个团队


	

	private String title;//title

	private String content;//content

	private java.util.Date date;//时间

	private String type;//1为系统消息；2为个人通知

	
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

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


	
}
