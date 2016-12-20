package com.osi.urm.domain;

// Generated Dec 1, 2016 5:20:37 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * OsiLookupValues generated by hbm2java
 */
@Entity
@Table(name = "osi_lookup_values")
public class OsiLookupValues implements java.io.Serializable {

	private Long id;
	private OsiLookupTypes osiLookupTypes;
	private String lookupValue;
	private String lookupDesc;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;

	public OsiLookupValues() {
	}

	public OsiLookupValues(Long id, OsiLookupTypes osiLookupTypes,
			String lookupValue, String lookupDesc) {
		this.id = id;
		this.osiLookupTypes = osiLookupTypes;
		this.lookupValue = lookupValue;
		this.lookupDesc = lookupDesc;
	}

	public OsiLookupValues(Long id, OsiLookupTypes osiLookupTypes,
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

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lookup_type_id", nullable = false)
	public OsiLookupTypes getOsiLookupTypes() {
		return this.osiLookupTypes;
	}

	public void setOsiLookupTypes(OsiLookupTypes osiLookupTypes) {
		this.osiLookupTypes = osiLookupTypes;
	}

	@Column(name = "lookup_value", nullable = false, length = 50)
	public String getLookupValue() {
		return this.lookupValue;
	}

	public void setLookupValue(String lookupValue) {
		this.lookupValue = lookupValue;
	}

	@Column(name = "lookup_desc", nullable = false, length = 100)
	public String getLookupDesc() {
		return this.lookupDesc;
	}

	public void setLookupDesc(String lookupDesc) {
		this.lookupDesc = lookupDesc;
	}

	@Column(name = "created_by")
	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", length = 0)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "updated_by")
	public Integer getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", length = 0)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
