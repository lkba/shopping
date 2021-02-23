package com.lkb.service.order;

import com.lkb.pojo.order.CategoryReport;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * 报表服务层接口
 */
public interface CategoryReportService {
    /**
     * 商品类目按日期统计(订单表关联查询)
     * @param date
     * @return
     */
    public List<CategoryReport> categoryReport(LocalDate date);

    public void createData();
    /**
     * 一级类目统计
     * @param date1
     * @param date2
     * @return
     */
    public List<Map> category1Count(String date1, String date2);

}
