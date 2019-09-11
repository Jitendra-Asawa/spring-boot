package com.infoobjects.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * Integer type id
 * String type name
 * Integer type age
 * Date type createAt, automatically populated
 * Date type updateAt, automatically populated
 * @JsonIgnoreProperties ignores externally provided values
 * @EntityListeners helps in automatic population of dates
 * 
 * @Temporal converts java date type to database type automatically
 */
@Entity(name = "Student")
//@Table(name = "student")
//@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = { "createAt", "updateAt" }, allowGetters = true)
public class Student {
	@Id
	private Integer id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private Integer age;
	
	@Column(nullable = false, updatable = false)
//	@CreatedDate
//	@Temporal(TemporalType.TIMESTAMP)
	private Long createdAt;
	
	@Column(nullable = false, updatable = true)
//	@LastModifiedDate
//	@Temporal(TemporalType.TIMESTAMP)
	private Long updateAt;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public Long getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Long updateAt) {
		this.updateAt = updateAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
