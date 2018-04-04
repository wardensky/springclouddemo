package com.example.demo;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String n1;
	private String n2;
	private String n3;
	private String n4;
	private String n5;
	private String n6;
	private Date createTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getN1() {
		return n1;
	}
	public void setN1(String n1) {
		this.n1 = n1;
	}
	public String getN2() {
		return n2;
	}
	public void setN2(String n2) {
		this.n2 = n2;
	}
	public String getN3() {
		return n3;
	}
	public void setN3(String n3) {
		this.n3 = n3;
	}
	public String getN4() {
		return n4;
	}
	public void setN4(String n4) {
		this.n4 = n4;
	}
	public String getN5() {
		return n5;
	}
	public void setN5(String n5) {
		this.n5 = n5;
	}
	public String getN6() {
		return n6;
	}
	public void setN6(String n6) {
		this.n6 = n6;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
