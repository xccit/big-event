package io.xccit.event.page;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/5
 * <p>分页结果返回工具</p>
 */
public class PageBean<T> {

    private Long total;
    private T data;

    public PageBean() {}
    public PageBean(Long total, T data) {
        this.total = total;
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "total=" + total +
                ", data=" + data +
                '}';
    }
}
