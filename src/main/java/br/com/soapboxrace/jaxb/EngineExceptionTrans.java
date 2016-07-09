package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EngineExpectionTrans", propOrder = { "description", "errorCode", "innerException", "message",
		"stackTrace" })
@XmlRootElement(name = "EngineExceptionTrans")
public class EngineExceptionTrans {

	@XmlElement(name = "Description")
	private String description;
	@XmlElement(name = "ErrorCode", required = true)
	private Integer errorCode;
	@XmlElement(name = "InnerException")
	private String innerException;
	@XmlElement(name = "Message")
	private String message;
	@XmlElement(name = "StackTrace")
	private String stackTrace;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getInnerException() {
		return innerException;
	}

	public void setInnerException(String innerException) {
		this.innerException = innerException;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}
}