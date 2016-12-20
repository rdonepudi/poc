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

public class OsiMenuEntriesDTO implements java.io.Serializable {

	private Long id;
	private OsiFunctionsDTO osiFunctions;
	private OsiMenusDTO osiMenusBySubMenuId;
	private OsiMenusDTO osiMenusByMenuId;
	private Long seq;
	private String prompt;
	private Date startDate;
	private Date endDate;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;

	public OsiMenuEntriesDTO() {
	}

	public OsiMenuEntriesDTO(Long id, OsiMenusDTO osiMenusByMenuId, Long seq,
			String prompt, Date startDate, Date endDate) {
		this.id = id;
		this.osiMenusByMenuId = osiMenusByMenuId;
		this.seq = seq;
		this.prompt = prompt;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public OsiMenuEntriesDTO(Long id, OsiFunctionsDTO osiFunctions,
			OsiMenusDTO osiMenusBySubMenuId, OsiMenusDTO osiMenusByMenuId, Long seq,
			String prompt, Date startDate, Date endDate, Integer createdBy,
			Date createdDate, Integer updatedBy, Date updatedDate) {
		this.id = id;
		this.osiFunctions = osiFunctions;
		this.osiMenusBySubMenuId = osiMenusBySubMenuId;
		this.osiMenusByMenuId = osiMenusByMenuId;
		this.seq = seq;
		this.prompt = prompt;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public OsiMenusDTO getOsiMenusBySubMenuId() {
		return this.osiMenusBySubMenuId;
	}

	public void setOsiMenusBySubMenuId(OsiMenusDTO osiMenusBySubMenuId) {
		this.osiMenusBySubMenuId = osiMenusBySubMenuId;
	}

	public OsiMenusDTO getOsiMenusByMenuId() {
		return this.osiMenusByMenuId;
	}

	public void setOsiMenusByMenuId(OsiMenusDTO osiMenusByMenuId) {
		this.osiMenusByMenuId = osiMenusByMenuId;
	}

	public Long getSeq() {
		return this.seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getPrompt() {
		return this.prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
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
