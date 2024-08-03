package io.xccit.event.utils;


/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/3
 * <p>当前用户</p>
 */
public class ThreadLocalUserUtil {

    private static final ThreadLocal threadLocal = new ThreadLocal();

    public static<T> void set(Object value) {
        threadLocal.set(value);
    }

    public static<T> T get() {
        return (T)threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }
}
