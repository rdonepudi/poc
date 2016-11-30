package com.osi.urm.service.dto;

// Generated Nov 28, 2016 11:44:49 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_EMPTY)
public class OsiUserOperationExclDTO implements java.io.Serializable {

	private Integer id;
	private OsiFunctionsDTO osiFunctions;
	private OsiUserDTO osiUser;
	private Date startDate;
	private Date endDate;
	private String operation;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;

	public OsiUserOperationExclDTO() {
	}

	public OsiUserOperationExclDTO(Integer id, OsiFunctionsDTO osiFunctions,
			OsiUserDTO osiUser, Date startDate, Date endDate, String operation) {
		this.id = id;
		this.osiFunctions = osiFunctions;
		this.osiUser = osiUser;
		this.startDate = startDate;
		this.endDate = endDate;
		this.operation = operation;
	}

	public OsiUserOperationExclDTO(Integer id, OsiFunctionsDTO osiFunctions,
			OsiUserDTO osiUser, Date startDate, Date endDate, String operation,
			Integer createdBy, Date createdDate, Integer updatedBy,
			Date updatedDate) {
		this.id = id;
		this.osiFunctions = osiFunctions;
		this.osiUser = osiUser;
		this.startDate = startDate;
		this.endDate = endDate;
		this.operation = operation;
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

	public OsiFunctionsDTO getOsiFunctions() {
		return this.osiFunctions;
	}

	public void setOsiFunctions(OsiFunctionsDTO osiFunctions) {
		this.osiFunctions = osiFunctions;
	}

	public OsiUserDTO getOsiUser() {
		return this.osiUser;
	}

	public void setOsiUser(OsiUserDTO osiUser) {
		this.osiUser = osiUser;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
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
