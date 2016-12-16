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

public class OsiFuncOperationsDTO implements java.io.Serializable {

	private int id;
	private OsiFunctionsDTO osiFunctions;
	private OsiOperationsDTO osiOperations;
	private String opUrl;
	private Date startDate;
	private Date endDate;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;

	public OsiFuncOperationsDTO() {
	}

	public OsiFuncOperationsDTO(int id, OsiFunctionsDTO osiFunctions,
			OsiOperationsDTO osiOperations, String opUrl, Date startDate,
			Date endDate) {
		this.id = id;
		this.osiFunctions = osiFunctions;
		this.osiOperations = osiOperations;
		this.opUrl = opUrl;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public OsiFuncOperationsDTO(int id, OsiFunctionsDTO osiFunctions,
			OsiOperationsDTO osiOperations, String opUrl, Date startDate,
			Date endDate, Integer createdBy, Date createdDate,
			Integer updatedBy, Date updatedDate) {
		this.id = id;
		this.osiFunctions = osiFunctions;
		this.osiOperations = osiOperations;
		this.opUrl = opUrl;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	public String getOpUrl() {
		return this.opUrl;
	}

	public void setOpUrl(String opUrl) {
		this.opUrl = opUrl;
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
