package com.tranquyet.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString(of = { "id", "createdBy", "createdDate", "modifiedDate", "modifiedBy" })
@NoArgsConstructor
public abstract class BasedEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "createdDate")
	@CreatedDate
	private Date createdDate;

	@Column(name = "modifiedDate")
	@LastModifiedDate
	private Date modifiedDate;

	@Column(name = "createdBy")
	@CreatedBy
	private String createdBy;

	@Column(name = "modifiedBy")
	@LastModifiedBy
	private String modifiedBy;

}
