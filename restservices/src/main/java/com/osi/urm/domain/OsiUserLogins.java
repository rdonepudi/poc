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
 * OsiUserLogins generated by hbm2java
 */
@Entity
@Table(name = "osi_user_logins")
public class OsiUserLogins implements java.io.Serializable {

	private int id;
	private OsiUser osiUser;
	private Date startTime;
	private Date endTime;
	private Integer pid;
	private String loginType;
	private String token;
	private Integer tokenExpTime;

	public OsiUserLogins() {
	}

	public OsiUserLogins(int id, OsiUser osiUser, Date startTime) {
		this.id = id;
		this.osiUser = osiUser;
		this.startTime = startTime;
	}

	public OsiUserLogins(int id, OsiUser osiUser, Date startTime, Date endTime,
			Integer pid, String loginType, String token, Integer tokenExpTime) {
		this.id = id;
		this.osiUser = osiUser;
		this.startTime = startTime;
		this.endTime = endTime;
		this.pid = pid;
		this.loginType = loginType;
		this.token = token;
		this.tokenExpTime = tokenExpTime;
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
	@JoinColumn(name = "user_id", nullable = false)
	public OsiUser getOsiUser() {
		return this.osiUser;
	}

	public void setOsiUser(OsiUser osiUser) {
		this.osiUser = osiUser;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_time", nullable = false, length = 0)
	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_time", length = 0)
	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Column(name = "pid")
	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Column(name = "login_type", length = 50)
	public String getLoginType() {
		return this.loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	@Column(name = "token", length = 1000)
	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Column(name = "token_exp_time")
	public Integer getTokenExpTime() {
		return this.tokenExpTime;
	}

	public void setTokenExpTime(Integer tokenExpTime) {
		this.tokenExpTime = tokenExpTime;
	}

}
