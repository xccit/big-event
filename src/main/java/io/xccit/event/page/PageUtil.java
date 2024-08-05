package io.xccit.event.page;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/5
 * <p>分页参数接收工具</p>
 */
public class PageUtil {

    private Integer pageNum;
    private Integer pageSize;
    public PageUtil()
    {
        this.pageNum = 1;
        this.pageSize = 10;
    }
    public PageUtil(Integer pageNum, Integer pageSize)
    {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
