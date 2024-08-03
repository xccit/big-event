package io.xccit.event.resut;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/2
 * <p>返回对象</p>
 */
@ApiModel(value = "返回对象", description = "返回对象")
public class AjaxResult<T> {

    @ApiModelProperty(value = "状态码", name = "code")
    private Integer code;
    @ApiModelProperty(value = "返回信息", name = "message")
    private String message;
    @ApiModelProperty(value = "返回数据", name = "data")
    private T data;

    public AjaxResult() {
    }
    public AjaxResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public AjaxResult(AjaxHttpStatus status, T data){
        this.code = status.getCode();
        this.message = status.getMessage();
        this.data = data;
    }
    public static <T> AjaxResult<T> success(T data){
        return new AjaxResult<>(AjaxHttpStatus.SUCCESS,data);
    }
    public static <T> AjaxResult<T> success(String message,T data){
        return new AjaxResult<>(200,message,data);
    }
    public static <T> AjaxResult<T> success(AjaxHttpStatus status,T data){
        return new AjaxResult<>(status.getCode(),status.getMessage(),data);
    }
    public static <T> AjaxResult<T> success(AjaxHttpStatus status){
        return new AjaxResult<>(status.getCode(),status.getMessage(),null);
    }
    public static <T> AjaxResult<T> fail(Integer code,String message){
        return new AjaxResult<>(code,message,null);
    }
    public static <T> AjaxResult<T> fail(String message){
        return new AjaxResult<>(500,message,null);
    }
    public static <T> AjaxResult<T> fail(){
        return new AjaxResult<>(500,null,null);
    }
    public static <T> AjaxResult<T> fail(AjaxHttpStatus status){
        return new AjaxResult<>(status.getCode(),status.getMessage(),null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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

    @Override
    public String toString() {
        return "AjaxResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
