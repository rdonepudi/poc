package com.osi.urm.service.dto;

// Generated Nov 28, 2016 11:44:49 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class OsiMenuEntriesDTO implements java.io.Serializable {

	private Integer id;
	private OsiFunctionsDTO osiFunctions;
	private OsiMenusDTO osiMenusBySubMenuId;
	private OsiMenusDTO osiMenusByMenuId;
	private Integer seq;
	private String menuPrompt;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private Date startDate;
	private Date endDate;

	public OsiMenuEntriesDTO() {
	}

	public OsiMenuEntriesDTO(Integer id, Date startDate, Date endDate) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	
	public OsiMenuEntriesDTO(Integer id, OsiMenusDTO osiMenusByMenuId, Integer seq,
			String menuPrompt) {
		this.id = id;
		this.osiMenusByMenuId = osiMenusByMenuId;
		this.seq = seq;
		this.menuPrompt = menuPrompt;
	}

	public OsiMenuEntriesDTO(Integer id, OsiFunctionsDTO osiFunctions,
			OsiMenusDTO osiMenusBySubMenuId, OsiMenusDTO osiMenusByMenuId, Integer seq,
			String menuPrompt, Integer createdBy, Date createdDate,
			Integer updatedBy, Date updatedDate,Date startDate,Date endDate) {
		this.id = id;
		this.osiFunctions = osiFunctions;
		this.osiMenusBySubMenuId = osiMenusBySubMenuId;
		this.osiMenusByMenuId = osiMenusByMenuId;
		this.seq = seq;
		this.menuPrompt = menuPrompt;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.startDate=startDate;
		this.endDate=endDate;
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

	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getMenuPrompt() {
		return this.menuPrompt;
	}

	public void setMenuPrompt(String menuPrompt) {
		this.menuPrompt = menuPrompt;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
