package com.util;

import com.common.component.param.AbstractPageParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 分页工具辅助类
 * 
 * @author song.chang
 * @create 2015年8月27日
 */
public class PageUtil {
    public static final int DEFAULT_PAGE_INDEX = 1; // 默认页码值
    public static final int DEFAULT_PAGE_SIZE = 10;// 默认条数
    public static final int DEFAULT_PAGE_OFFSET = 0;// 默认起始行

    /**
     * 初始化分页RowBounds
     *
     * @param param 分页参数
     * @return
     */
    public static RowBounds initRowBounds(AbstractPageParam param) {
        if (param.getPageNum() == 0) {
            param.setPageNum(DEFAULT_PAGE_INDEX);
        }
        if (param.getPageSize() == 0) {
            param.setPageSize(DEFAULT_PAGE_SIZE);
        }
        return initRowBounds(param.getPageNum(), param.getPageSize());
    }

    /**
     * 初始化分页RowBounds
     * 
     * @param pageNum
     * @param pageSize
     * @return
     */
    public static RowBounds initRowBounds(int pageNum, int pageSize) {
        // 封装分页参数
        pageNum = pageNum < 1 ? DEFAULT_PAGE_INDEX : pageNum;
        pageSize = pageSize < 1 ? DEFAULT_PAGE_SIZE : pageSize;
        // 设置RowBounds的offset(起始行)和limit(每页条数)
        int offset = (pageNum - 1) * pageSize;
        return new RowBounds(offset, pageSize);
    }

    /**
     * 计算总页数
     * 
     * @param totalCount
     * @param pageSize
     * @return
     */
    public static int calculatePageCount(int totalCount, int pageSize) {
        pageSize = pageSize == 0 ? DEFAULT_PAGE_SIZE : pageSize;
        return (totalCount + pageSize - 1) / pageSize;
    }

    /**
     * 分页信息初始化
     */
    public static void initSplitPageInfo(Pagination pagination, HttpServletRequest request) {
        String pageMethod = request.getParameter("pageMethod");
        String currentPageNum = request.getParameter("currentPageNum");
        String lastPageNum = request.getParameter("lastPageNum");

        pagination.setPageStartRow(0);
        pagination.setPageSize(10);

        if (StringUtils.isNotEmpty(request.getParameter("pageStartRow"))) {
            pagination.setPageStartRow(Integer.parseInt(request.getParameter("pageStartRow")));
        }

        initSplitPageInfo(pagination, pageMethod, currentPageNum, lastPageNum);
    }

    /**
     * 分页信息装配完成
     */
    public static void getSplitPageInfo(Pagination pagination, HttpServletRequest request) {
        setSplitPageNP(pagination);
        /**
         * 向orderForm中填充分页信息
         */
        request.setAttribute("pagination", pagination);
        Map paraMap = request.getParameterMap();
        request.setAttribute("paraMap", paraMap);
        request.setAttribute("action", request.getServletPath());
    }

    /**
     * 分页信息类初始化
     */
    public static void initSplitPageInfo(Pagination pagination, String pageMethod, String currentPageNum, String lastPageNum) {
        if (StringUtils.isNotEmpty(pageMethod)) {
            if (pageMethod.contains("first")) {
                pagination.setCurrentPage(1);
            }
            if (pageMethod.contains("previous")) {
                pagination.setCurrentPage(Integer.parseInt(currentPageNum) - 1);
            }
            if (pageMethod.contains("next")) {
                pagination.setCurrentPage(Integer.parseInt(currentPageNum) + 1);
            }
            if (pageMethod.contains("last")) {
                pagination.setCurrentPage(Integer.parseInt(lastPageNum));
            }
            if (pageMethod.contains("gotoPage")) {
                pagination.setCurrentPage(Integer.parseInt(currentPageNum));
            }
        } else {
            pagination.setCurrentPage(1);
        }
    }

    /**
     * 分页信息动作初始化--上、下一页
     */
    public static void setSplitPageNP(Pagination pagination) {
        /**
         * 前一页
         */
        if (pagination.getCurrentPage() > 1) {
            pagination.setPrevious(true);
        } else {
            pagination.setPrevious(false);
        }
        /**
         * 后一页
         */
        if (pagination.getCurrentPage() < pagination.getTotalPages()) {
            pagination.setNext(true);
        } else {
            pagination.setNext(false);
        }
    }

    /**
     * 分页信息组装
     */
    public static void getSplitPageInfo(Pagination pagination, int total) {
        int totalPages = 0;
        if ((total % pagination.getPageSize()) == 0) {
            totalPages = total / pagination.getPageSize();
        } else {
            totalPages = total / pagination.getPageSize() + 1;
        }
        if (pagination.getCurrentPage() < totalPages) {
            pagination.setNext(true);
        }
        if (pagination.getCurrentPage() > 1) {
            pagination.setPrevious(true);
        }
        // 不能乘10 减 10 每页数量是不变的
        pagination.setPageStartRow(pagination.getCurrentPage() * pagination.getPageSize() - pagination.getPageSize());
        pagination.setTotalRows(total);
        pagination.setTotalPages(totalPages);
    }

    public static RowBounds paginationToRowBounds(Pagination pagination) {
        int offset = (pagination.getCurrentPage() - 1) * pagination.getPageSize();
        int rows = pagination.getPageSize();
        return new RowBounds(offset, rows);
    }
}
