package com.osi.urm.exception;

/**
 * @author rdonepudi
 *
 */
public class DataAccessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String systemMessage;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getSystemMessage() {
		return systemMessage;
	}
	public void setSystemMessage(String systemMessage) {
		this.systemMessage = systemMessage;
	}
	public DataAccessException(String errorCode, String systemMessage) {
		super();
		this.errorCode = errorCode;
		this.systemMessage = systemMessage;
	}
}
