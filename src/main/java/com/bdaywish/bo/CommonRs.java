package com.bdaywish.bo;

public class CommonRs<T> extends BaseResponse {
	
	public T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


}
