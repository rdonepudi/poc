package com.osi.urm.service.dto;

// Generated Nov 28, 2016 11:44:49 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_EMPTY)
public class OsiResponsibilitiesDTO implements java.io.Serializable {

	private Integer id;
	private OsiMenusDTO osiMenus;
	private String respName;
	private String description;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private Set<OsiRespUserDTO> osiRespUsers = new HashSet<OsiRespUserDTO>(0);

	public OsiResponsibilitiesDTO() {
	}

	public OsiResponsibilitiesDTO(Integer id, OsiMenusDTO osiMenus, String respName) {
		this.id = id;
		this.osiMenus = osiMenus;
		this.respName = respName;
	}

	public OsiResponsibilitiesDTO(Integer id, OsiMenusDTO osiMenus, String respName,
			String description, Integer createdBy, Date createdDate,
			Integer updatedBy, Date updatedDate, Set<OsiRespUserDTO> osiRespUsers) {
		this.id = id;
		this.osiMenus = osiMenus;
		this.respName = respName;
		this.description = description;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.osiRespUsers = osiRespUsers;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OsiMenusDTO getOsiMenus() {
		return this.osiMenus;
	}

	public void setOsiMenus(OsiMenusDTO osiMenus) {
		this.osiMenus = osiMenus;
	}

	public String getRespName() {
		return this.respName;
	}

	public void setRespName(String respName) {
		this.respName = respName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Set<OsiRespUserDTO> getOsiRespUsers() {
		return this.osiRespUsers;
	}

	public void setOsiRespUsers(Set<OsiRespUserDTO> osiRespUsers) {
		this.osiRespUsers = osiRespUsers;
	}

}
