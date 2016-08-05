package com.util;

import java.io.Serializable;
import java.util.Map;

/**
 * 分页工具
 */
public class Pagination implements Serializable {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 891967668929894558L;
    /**
     * 查询参数map
     */
    private Map<String, Object> paramMap;
    public Map<String, Object> getParamMap() {
        return paramMap;
    }

    /**
     * 每页默认10条数据
     */
    protected int pageSize = 10;
    /**
     * 当前页
     */
    protected int currentPage = 1;
    /**
     * 总页数
     */
    protected int totalPages = 0;
    /**
     * 总数据数
     */
    protected int totalRows = 0;
    /**
     * 每页的起始行数
     */
    protected int pageStartRow = 0;
    /**
     * 每页显示数据的终止行数
     */
    protected int pageEndRow = 0;
    /**
     * 是否有下一页
     */
    boolean next = false;
    /**
     * 是否有前一页
     */
    boolean previous = false;

    public Pagination(int rows, int pageSize) {
        this.init(rows, pageSize);
    }

    public Pagination() {
    }

    /**
     * 初始化分页参数:需要先设置totalRows
     */
    public void init(int rows, int pageSize) {
        this.pageSize = pageSize;
        this.totalRows = rows;

        if ((totalRows % pageSize) == 0) {
            totalPages = totalRows / pageSize;
        } else {
            totalPages = totalRows / pageSize + 1;
        }

    }

    public void init(int rows, int pageSize, int currentPage) {
        this.pageSize = pageSize;
        this.totalRows = rows;

        if ((totalRows % pageSize) == 0) {
            totalPages = totalRows / pageSize;
        } else {
            totalPages = totalRows / pageSize + 1;
        }
        if (currentPage != 0) gotoPage(currentPage);
    }

    /**
     * 计算当前页的取值范围：pageStartRow和pageEndRow
     */
    private void calculatePage() {
        previous = (currentPage - 1) > 0;
        next = currentPage < totalPages;
        if (currentPage * pageSize < totalRows) { // 判断是否为最后一页
            pageEndRow = currentPage * pageSize;
            pageStartRow = pageEndRow - pageSize;
        } else {
            pageEndRow = totalRows;
            pageStartRow = pageSize * (totalPages - 1);
        }
    }

    /**
     * 直接跳转到指定页数的页面
     *
     * @param page
     */
    public void gotoPage(int page) {
        currentPage = page;
        calculatePage();
    }


    public String debugString() {

        return "共有数据数:" + totalRows + "共有页数:" + totalPages + "当前页数为:"
                + currentPage + "是否有前一页:" + previous + "是否有下一页:"
                + next + "开始行数:" + pageStartRow + "终止行数:" + pageEndRow;

    }

    public void setParamMap(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getPageStartRow() {
        return pageStartRow;
    }

    public void setPageStartRow(int pageStartRow) {
        this.pageStartRow = pageStartRow;
    }

    public int getPageEndRow() {
        return pageEndRow;
    }

    public void setPageEndRow(int pageEndRow) {
        this.pageEndRow = pageEndRow;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public boolean isPrevious() {
        return previous;
    }

    public void setPrevious(boolean previous) {
        this.previous = previous;
    }
}
