package com.osi.urm.service.dto;

// Generated Dec 1, 2016 5:20:37 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class OsiUserOperationExclDTO implements java.io.Serializable {

	private Long id;
	private OsiFunctionsDTO osiFunctions;
	private OsiOperationsDTO osiOperations;
	private OsiUserDTO osiUser;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;

	public OsiUserOperationExclDTO() {
	}

	public OsiUserOperationExclDTO(Long id, OsiFunctionsDTO osiFunctions,
			OsiOperationsDTO osiOperations, OsiUserDTO osiUser) {
		this.id = id;
		this.osiFunctions = osiFunctions;
		this.osiOperations = osiOperations;
		this.osiUser = osiUser;
	}

	public OsiUserOperationExclDTO(Long id, OsiFunctionsDTO osiFunctions,
			OsiOperationsDTO osiOperations, OsiUserDTO osiUser, Integer createdBy,
			Date createdDate, Integer updatedBy, Date updatedDate) {
		this.id = id;
		this.osiFunctions = osiFunctions;
		this.osiOperations = osiOperations;
		this.osiUser = osiUser;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OsiFunctionsDTO getOsiFunctions() {
		return this.osiFunctions;
	}

	public void setOsiFunctions(OsiFunctionsDTO osiFunctions) {
		this.osiFunctions = osiFunctions;
	}

	public OsiOperationsDTO getOsiOperations() {
		return this.osiOperations;
	}

	public void setOsiOperations(OsiOperationsDTO osiOperations) {
		this.osiOperations = osiOperations;
	}

	public OsiUserDTO getOsiUser() {
		return this.osiUser;
	}

	public void setOsiUser(OsiUserDTO osiUser) {
		this.osiUser = osiUser;
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
