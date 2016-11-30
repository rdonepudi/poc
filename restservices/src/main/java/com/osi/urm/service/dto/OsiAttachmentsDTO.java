package com.osi.urm.service.dto;

// Generated Nov 28, 2016 11:44:49 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_EMPTY)
public class OsiAttachmentsDTO implements java.io.Serializable {

	private Long id;
	private OsiUserDTO osiUser;
	private byte[] attachment;
	private String attachmentType;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;

	public OsiAttachmentsDTO() {
	}

	public OsiAttachmentsDTO(Long id, OsiUserDTO osiUser, byte[] attachment,
			String attachmentType) {
		this.id = id;
		this.osiUser = osiUser;
		this.attachment = attachment;
		this.attachmentType = attachmentType;
	}

	public OsiAttachmentsDTO(Long id, OsiUserDTO osiUser, byte[] attachment,
			String attachmentType, Integer createdBy, Date createdDate,
			Integer updatedBy, Date updatedDate) {
		this.id = id;
		this.osiUser = osiUser;
		this.attachment = attachment;
		this.attachmentType = attachmentType;
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

	public OsiUserDTO getOsiUser() {
		return this.osiUser;
	}

	public void setOsiUser(OsiUserDTO osiUser) {
		this.osiUser = osiUser;
	}

	public byte[] getAttachment() {
		return this.attachment;
	}

	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}

	public String getAttachmentType() {
		return this.attachmentType;
	}

	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
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
