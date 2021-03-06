package com.jyx.s2sh.shop.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Forder entity. @author MyEclipse Persistence Tools
 */

public class Forder implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String phone;
	private String remark;
	private Timestamp date;
	private BigDecimal total;
	private String post;
	private String address;
	private User user;
	private Status status;
	// 通过主表查找子表
	private List<Sorder> sorderList=new ArrayList<Sorder>();
	
	
	
	@Override
	public String toString() {
		return "Forder [id=" + id + ", name=" + name + ", phone=" + phone + ", remark=" + remark + ", date=" + date
				+ ", total=" + total + ", post=" + post + ", address=" + address + ", user=" + user + ", status="
				+ status + ", sorderList=" + sorderList + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	

	public List<Sorder> getSorderList() {
		return sorderList;
	}

	public void setSorderList(List<Sorder> sorderList) {
		this.sorderList = sorderList;
	}

	/** default constructor */
	public Forder() {
	}

	/** minimal constructor */
	public Forder(Timestamp date) {
		this.date = date;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}