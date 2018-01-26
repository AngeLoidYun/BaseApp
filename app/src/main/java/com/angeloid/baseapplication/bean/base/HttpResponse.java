package com.angeloid.baseapplication.bean.base;

import java.io.Serializable;

/**
 * @author yunjw
 *         Created at 2018/1/26.
 *         Time is 9:22 now.
 *         (#^.^#)
 */

public class HttpResponse<T>  implements Serializable{
    private static final long serialVersionUID = -686453405647539973L;

    private int code;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
}
