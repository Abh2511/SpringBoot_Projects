package org.springboot.notesmanagementsystem.entity;

public class ResponseStructure<T>
{
	
	private String message;
	
	private Integer statusCode;
	
	private T data;

	public ResponseStructure() {
		super();
	}

	public ResponseStructure(String message,Integer statusCode, T data) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseStructure [message=" + message + ", statusCode=" + statusCode + ", data=" + data + "]";
	}
	
	
	
	
	  

		
	
	
	
	
	
	
	
	
	
	
	

}
