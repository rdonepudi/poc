package com.osi.urm.service.dto;

// Generated Dec 1, 2016 5:20:37 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

public class OsiLookupValuesDTO implements java.io.Serializable {

	private Long id;
	private OsiLookupTypesDTO osiLookupTypes;
	private String lookupValue;
	private String lookupDesc;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;

	public OsiLookupValuesDTO() {
	}

	public OsiLookupValuesDTO(Long id, OsiLookupTypesDTO osiLookupTypes,
			String lookupValue, String lookupDesc) {
		this.id = id;
		this.osiLookupTypes = osiLookupTypes;
		this.lookupValue = lookupValue;
		this.lookupDesc = lookupDesc;
	}

	public OsiLookupValuesDTO(Long id, OsiLookupTypesDTO osiLookupTypes,
			String lookupValue, String lookupDesc, Integer createdBy,
			Date createdDate, Integer updatedBy, Date updatedDate) {
		this.id = id;
		this.osiLookupTypes = osiLookupTypes;
		this.lookupValue = lookupValue;
		this.lookupDesc = lookupDesc;
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

	public OsiLookupTypesDTO getOsiLookupTypes() {
		return this.osiLookupTypes;
	}

	public void setOsiLookupTypes(OsiLookupTypesDTO osiLookupTypes) {
		this.osiLookupTypes = osiLookupTypes;
	}

	public String getLookupValue() {
		return this.lookupValue;
	}

	public void setLookupValue(String lookupValue) {
		this.lookupValue = lookupValue;
	}

	public String getLookupDesc() {
		return this.lookupDesc;
	}

	public void setLookupDesc(String lookupDesc) {
		this.lookupDesc = lookupDesc;
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
