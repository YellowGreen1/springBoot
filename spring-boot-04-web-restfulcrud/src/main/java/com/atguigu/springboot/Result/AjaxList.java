package com.atguigu.springboot.Result;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
/**
 * @Description: 返回值处理
 * @Date: 2019/1/22
 * @Auther: 
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AjaxList<T> {
    private boolean isSuccess;
    private T data;
 
    public static <T> AjaxList<T> createSuccess(T data) {
        return new AjaxList<T>(true, data);
    }
 
    public static <T> AjaxList<T> createFail(T data) {
        return new AjaxList<T>(false, data);
    }

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public AjaxList(boolean isSuccess, T data) {
		super();
		this.isSuccess = isSuccess;
		this.data = data;
	}

	public AjaxList() {
		super();
	}
	
}