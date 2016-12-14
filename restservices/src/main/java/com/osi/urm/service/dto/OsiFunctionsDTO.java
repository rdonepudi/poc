package com.osi.urm.service.dto;

// Generated Nov 28, 2016 11:44:49 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_EMPTY)
public class OsiFunctionsDTO implements java.io.Serializable {

	private Integer id;
	private String funcName;
	private String funcType;
	private String funcValue;
	private String parameters;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private Set<OsiUserFuncExclDTO> osiUserFuncExcls = new HashSet<OsiUserFuncExclDTO>(
			0);
	private Set<OsiMenuEntriesDTO> osiMenuEntrieses = new HashSet<OsiMenuEntriesDTO>(
			0);
	private Set<OsiUserOperationExclDTO> osiUserOperationExcls = new HashSet<OsiUserOperationExclDTO>(
			0);

	public OsiFunctionsDTO() {
	}

	public OsiFunctionsDTO(Integer id, String funcType, String funcValue,String funcName) {
		this.id = id;
		this.funcName = funcName;
		this.funcType = funcType;
		this.funcValue = funcValue;
	}

	public OsiFunctionsDTO(Integer id, String funcType, String funcValue,
			String parameters, Integer createdBy, Date createdDate,String funcName,
			Integer updatedBy, Date updatedDate,
			Set<OsiUserFuncExclDTO> osiUserFuncExcls,
			Set<OsiMenuEntriesDTO> osiMenuEntrieses,
			Set<OsiUserOperationExclDTO> osiUserOperationExcls) {
		this.id = id;
		this.funcName = funcName;
		this.funcType = funcType;
		this.funcValue = funcValue;
		this.parameters = parameters;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.osiUserFuncExcls = osiUserFuncExcls;
		this.osiMenuEntrieses = osiMenuEntrieses;
		this.osiUserOperationExcls = osiUserOperationExcls;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFuncType() {
		return this.funcType;
	}

	public void setFuncType(String funcType) {
		this.funcType = funcType;
	}

	public String getFuncValue() {
		return this.funcValue;
	}

	public void setFuncValue(String funcValue) {
		this.funcValue = funcValue;
	}
	
	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
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

	public Set<OsiUserFuncExclDTO> getOsiUserFuncExcls() {
		return this.osiUserFuncExcls;
	}

	public void setOsiUserFuncExcls(Set<OsiUserFuncExclDTO> osiUserFuncExcls) {
		this.osiUserFuncExcls = osiUserFuncExcls;
	}

	public Set<OsiMenuEntriesDTO> getOsiMenuEntrieses() {
		return this.osiMenuEntrieses;
	}

	public void setOsiMenuEntrieses(Set<OsiMenuEntriesDTO> osiMenuEntrieses) {
		this.osiMenuEntrieses = osiMenuEntrieses;
	}

	public Set<OsiUserOperationExclDTO> getOsiUserOperationExcls() {
		return this.osiUserOperationExcls;
	}

	public void setOsiUserOperationExcls(
			Set<OsiUserOperationExclDTO> osiUserOperationExcls) {
		this.osiUserOperationExcls = osiUserOperationExcls;
	}

	

}
