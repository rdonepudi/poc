package com.osi.urm.service.dto;

// Generated Dec 1, 2016 5:20:37 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class OsiMenusDTO implements java.io.Serializable {

	private Long id;
	private String menuName;
	private String description;
	private Long createdBy;
	private Date createdDate;
	private Long updatedBy;
	private Date updatedDate;
	private Set<OsiMenuEntriesDTO> osiMenuEntriesesForSubMenuId = new HashSet<OsiMenuEntriesDTO>(
			0);
	private Set<OsiResponsibilitiesDTO> osiResponsibilitieses = new HashSet<OsiResponsibilitiesDTO>(
			0);
	private Set<OsiMenuEntriesDTO> osiMenuEntriesesForMenuId = new HashSet<OsiMenuEntriesDTO>(
			0);

	public OsiMenusDTO() {
	}

	public OsiMenusDTO(Long id, String menuName) {
		this.id = id;
		this.menuName = menuName;
	}

	public OsiMenusDTO(Long id, String menuName, String description,
			Long createdBy, Date createdDate, Long updatedBy,
			Date updatedDate, Set<OsiMenuEntriesDTO> osiMenuEntriesesForSubMenuId,
			Set<OsiResponsibilitiesDTO> osiResponsibilitieses,
			Set<OsiMenuEntriesDTO> osiMenuEntriesesForMenuId) {
		this.id = id;
		this.menuName = menuName;
		this.description = description;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.osiMenuEntriesesForSubMenuId = osiMenuEntriesesForSubMenuId;
		this.osiResponsibilitieses = osiResponsibilitieses;
		this.osiMenuEntriesesForMenuId = osiMenuEntriesesForMenuId;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Set<OsiMenuEntriesDTO> getOsiMenuEntriesesForSubMenuId() {
		return this.osiMenuEntriesesForSubMenuId;
	}

	public void setOsiMenuEntriesesForSubMenuId(
			Set<OsiMenuEntriesDTO> osiMenuEntriesesForSubMenuId) {
		this.osiMenuEntriesesForSubMenuId = osiMenuEntriesesForSubMenuId;
	}

	public Set<OsiResponsibilitiesDTO> getOsiResponsibilitieses() {
		return this.osiResponsibilitieses;
	}

	public void setOsiResponsibilitieses(
			Set<OsiResponsibilitiesDTO> osiResponsibilitieses) {
		this.osiResponsibilitieses = osiResponsibilitieses;
	}

	public Set<OsiMenuEntriesDTO> getOsiMenuEntriesesForMenuId() {
		return this.osiMenuEntriesesForMenuId;
	}

	public void setOsiMenuEntriesesForMenuId(
			Set<OsiMenuEntriesDTO> osiMenuEntriesesForMenuId) {
		this.osiMenuEntriesesForMenuId = osiMenuEntriesesForMenuId;
	}

}
