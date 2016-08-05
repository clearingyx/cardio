package com.other.resp;

/**
 * 分页结果基类
 * 
 * @author changhao.shao
 * @create 2015年9月14日
 */
public class PageResp {
    private int rowCount; // 总条数
    private int pageCount; // 总页数

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
