package com.howtodoinjava.entity;

import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {
/*
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ID", unique = true, nullable = false)
	private String id;
*/
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ID", unique = true, nullable = false)
	@Type(type="uuid-char")
	private UUID id;
	
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "firstname", column = @Column(name = "FIRSTNAME") ),
			@AttributeOverride(name = "lastname", column = @Column(name = "LASTNAME") ),
			@AttributeOverride(name = "email", column = @Column(name = "EMAIL") ),
			@AttributeOverride(name = "telephone", column = @Column(name = "TELEPHONE") ) })
	private Credentials credentials;
/*
	public UUID getId() {
		return UUID.fromString(id);
	}

	public void setId(UUID id) {
		this.id = id.toString();
	}
*/
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

}