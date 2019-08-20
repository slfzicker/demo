package com.cy.service.exception;

public class ServiceException extends RuntimeException{

	/**
	 * 业务层运行异常抛出
	 */
	private static final long serialVersionUID = -4723530990076515835L;

	public ServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
      
}
