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
 * OsiRespUser generated by hbm2java
 */
@Entity
@Table(name = "osi_resp_user")
public class OsiRespUser implements java.io.Serializable {

	private Long id;
	private OsiUser osiUser;
	private OsiResponsibilities osiResponsibilities;
	private Date startDate;
	private Date endDate;
	private Boolean defaultResp;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;

	public OsiRespUser() {
	}

	public OsiRespUser(Long id, Date startDate, Date endDate) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public OsiRespUser(Long id, OsiUser osiUser,
			OsiResponsibilities osiResponsibilities, Date startDate,
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
	@JoinColumn(name = "user_id")
	public OsiUser getOsiUser() {
		return this.osiUser;
	}

	public void setOsiUser(OsiUser osiUser) {
		this.osiUser = osiUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resp_id")
	public OsiResponsibilities getOsiResponsibilities() {
		return this.osiResponsibilities;
	}

	public void setOsiResponsibilities(OsiResponsibilities osiResponsibilities) {
		this.osiResponsibilities = osiResponsibilities;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date", nullable = false, length = 0)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date", nullable = false, length = 0)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "default_resp")
	public Boolean getDefaultResp() {
		return this.defaultResp;
	}

	public void setDefaultResp(Boolean defaultResp) {
		this.defaultResp = defaultResp;
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
