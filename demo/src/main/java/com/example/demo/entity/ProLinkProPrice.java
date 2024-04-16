package com.example.demo.entity;

import java.sql.Timestamp;
import java.util.Date;

public class ProLinkProPrice {
	
	private String link_pro_code;
	private Date price_dt;
	private Timestamp create_dt;
	private Timestamp modify_dt;
	
	public String getLink_pro_code() {
		return link_pro_code;
	}
	public void setLink_pro_code(String link_pro_code) {
		this.link_pro_code = link_pro_code;
	}
	public Date getPrice_dt() {
		return price_dt;
	}
	public void setPrice_dt(Date price_dt) {
		this.price_dt = price_dt;
	}
	public Timestamp getCreate_dt() {
		return create_dt;
	}
	public void setCreate_dt(Timestamp create_dt) {
		this.create_dt = create_dt;
	}
	public Timestamp getModify_dt() {
		return modify_dt;
	}
	public void setModify_dt(Timestamp modify_dt) {
		this.modify_dt = modify_dt;
	}
}
