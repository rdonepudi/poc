package com.osi.urm.service.dto;

// Generated Nov 30, 2016 8:27:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

public class OsiOperationsDTO implements java.io.Serializable {

	private Integer id;
	private OsiFunctionsDTO osiFunctionsDTO;
	private String opType;
	private String opValue;
	private String parameters;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;

	public OsiOperationsDTO() {
	}

	public OsiOperationsDTO(String opType) {
		this.opType = opType;
	}

	public OsiOperationsDTO(OsiFunctionsDTO osiFunctionsDTO, String opType,
			String opValue, String parameters, Integer createdBy,
			Date createdDate, Integer updatedBy, Date updatedDate) {
		this.osiFunctionsDTO = osiFunctionsDTO;
		this.opType = opType;
		this.opValue = opValue;
		this.parameters = parameters;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OsiFunctionsDTO getOsiFunctionsDTO() {
		return this.osiFunctionsDTO;
	}

	public void setOsiFunctions(OsiFunctionsDTO osiFunctionsDTO) {
		this.osiFunctionsDTO = osiFunctionsDTO;
	}

	public String getOpType() {
		return this.opType;
	}

	public void setOpType(String opType) {
		this.opType = opType;
	}

	public String getOpValue() {
		return this.opValue;
	}

	public void setOpValue(String opValue) {
		this.opValue = opValue;
	}

	public String getParameters() {
		return this.parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
