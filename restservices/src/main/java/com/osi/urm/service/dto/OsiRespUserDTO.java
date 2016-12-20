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

public class OsiRespUserDTO implements java.io.Serializable {

	private Long id;
	private OsiUserDTO osiUser;
	private OsiResponsibilitiesDTO osiResponsibilities;
	private Date startDate;
	private Date endDate;
	private Boolean defaultResp;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;

	public OsiRespUserDTO() {
	}

	public OsiRespUserDTO(Long id, Date startDate, Date endDate) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public OsiRespUserDTO(Long id, OsiUserDTO osiUser,
			OsiResponsibilitiesDTO osiResponsibilities, Date startDate,
			Date endDate, Boolean defaultResp, Integer createdBy,
			Date createdDate, Integer updatedBy, Date updatedDate) {
		this.id = id;
		this.osiUser = osiUser;
		this.osiResponsibilities = osiResponsibilities;
		this.startDate = startDate;
		this.endDate = endDate;
		this.defaultResp = defaultResp;
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

	public OsiUserDTO getOsiUser() {
		return this.osiUser;
	}

	public void setOsiUser(OsiUserDTO osiUser) {
		this.osiUser = osiUser;
	}

	public OsiResponsibilitiesDTO getOsiResponsibilities() {
		return this.osiResponsibilities;
	}

	public void setOsiResponsibilities(OsiResponsibilitiesDTO osiResponsibilities) {
		this.osiResponsibilities = osiResponsibilities;
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

	public Boolean getDefaultResp() {
		return this.defaultResp;
	}

	public void setDefaultResp(Boolean defaultResp) {
		this.defaultResp = defaultResp;
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
