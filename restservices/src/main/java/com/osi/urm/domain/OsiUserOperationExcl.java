package com.osi.urm.domain;

// Generated Nov 28, 2016 7:51:32 PM by Hibernate Tools 3.4.0.CR1

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

/**
 * OsiUserOperationExcl generated by hbm2java
 */
@Entity
@Table(name = "osi_user_operation_excl")
public class OsiUserOperationExcl implements java.io.Serializable {

	private int id;
	private OsiFunctions osiFunctions;
	private OsiUser osiUser;
	private Date startDate;
	private Date endDate;
	private String operation;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;

	public OsiUserOperationExcl() {
	}

	public OsiUserOperationExcl(int id, OsiFunctions osiFunctions,
			OsiUser osiUser, Date startDate, Date endDate, String operation) {
		this.id = id;
		this.osiFunctions = osiFunctions;
		this.osiUser = osiUser;
		this.startDate = startDate;
		this.endDate = endDate;
		this.operation = operation;
	}

	public OsiUserOperationExcl(int id, OsiFunctions osiFunctions,
			OsiUser osiUser, Date startDate, Date endDate, String operation,
			Integer createdBy, Date createdDate, Integer updatedBy,
			Date updatedDate) {
		this.id = id;
		this.osiFunctions = osiFunctions;
		this.osiUser = osiUser;
		this.startDate = startDate;
		this.endDate = endDate;
		this.operation = operation;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "func_id", nullable = false)
	public OsiFunctions getOsiFunctions() {
		return this.osiFunctions;
	}

	public void setOsiFunctions(OsiFunctions osiFunctions) {
		this.osiFunctions = osiFunctions;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public OsiUser getOsiUser() {
		return this.osiUser;
	}

	public void setOsiUser(OsiUser osiUser) {
		this.osiUser = osiUser;
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

	@Column(name = "operation", nullable = false, length = 50)
	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
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
