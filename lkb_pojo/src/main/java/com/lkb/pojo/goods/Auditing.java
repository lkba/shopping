package com.lkb.pojo.goods;


import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name="tb_auditing")
public class Auditing {

    private Integer id;
    private Date auditTime;
    private String result;//0  未通过  通过
    private String details;
    private String spu_id;//商品ID

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(String spu_id) {
        this.spu_id = spu_id;
    }
}
