package com.common.component.param;

/**
 * 抽象参数，接口分页查询时，需要继承该类
 */
public abstract class AbstractPageParam extends AbstractParam{
    /**
     * 当前第几页
     */
    protected int pageNum;

    /**
     * 每页记录数
     */
    protected int pageSize;

    /**
     * 参数校验，子类如果需要参数校验，必须复写该方法 如果校验失败，抛出一个的异常(可是任意异常，建议ParamCheckException)，异常的 msg 为错误提示
     * 该方法是靠google的gauva实现验证。
     */
    public abstract void paramCheck();

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
