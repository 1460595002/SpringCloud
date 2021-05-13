package cn.jinronga.springcloud.util;

/**
 * @ClassName R
 * @Author 郭金荣
 * @Date 2021/5/12 19:39
 * @Description R
 * @Version 1.0
 * 整个项目统一使用这个类型作为Ajax请求或远程方法调用返回响应的数据格式
 */
public class R<T> {

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";
    public static final String NO_MESSAGE = "NO_MESSAGE";
    public static final String NO_DATA = "NO_DATA";

    /**
     * 操作成功，不需要返回数据
     *
     * @return
     */
    public static R<String> successWithoutData() {
        return new R<String>(SUCCESS, NO_MESSAGE, NO_DATA);
    }

    /**
     * 操作成功，需要返回数据
     *
     * @param data
     * @return
     */
    public static <E> R<E> successWithData(E data) {
        return new R<>(SUCCESS, NO_MESSAGE, data);
    }

    /**
     * 操作失败，返回错误消息
     *
     * @param message
     * @return
     */
    public static <E> R<E> failed(String message) {
        return new R<>(FAILED, message, null);
    }

    private String result;
    private String message;
    private T data;

    public R() {

    }

    public R(String result, String message, T data) {
        super();
        this.result = result;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultEntity [result=" + result + ", message=" + message + ", data=" + data + "]";
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
