package com.suben.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "t_ec_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // JPA的注解方式
	@Column(length = 32)
	private Integer id;

	@Column(length = 32)
	private String userName;

	@Column(length = 50)
	private String telphone;

	@Column(length = 32)
	private String password;

	@Column(length = 50)
	private String realname;

	@Column(length = 50)
	@Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,4}", message = "无效的邮箱地址")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {

	}
	
	public User(String userName, String telphone, String password, String realname, String email) {
		super();
		this.userName = userName;
		this.telphone = telphone;
		this.password = password;
		this.realname = realname;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

}
