package com.infoobjects.model;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.persistence.*;

@Entity(name = "Customer")
//@Table(name = "Customer")
public class Customer {

	@Id
	@Column(name = "id", unique = true, columnDefinition = "Integer", insertable = true)
	private int id;
	@Column(name = "name", updatable = true, insertable = true, columnDefinition = "String")
	private String name;
	@Column(name = "amount", updatable = true, insertable = true, columnDefinition = "Integer")
	private int amount;
	@Column(name = "timeCreate", updatable = true, insertable = true, columnDefinition = "Long")
	private long timeCreate;
	@Column(name = "timeUpdate", updatable = true, insertable = true, columnDefinition = "Long")
	private long timeUpdate;

	public Customer() {
	}

	public Customer(int id, String name, long timeCreate, long timeUpdate) {
		this.id = id;
		this.name = name;
		this.timeCreate = timeCreate;
		this.timeUpdate = timeUpdate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTimeCreate(long timeCreate) {
		this.timeCreate = timeCreate;
	}

	public void setTimeUpdate(long timeUpdate) {
		this.timeUpdate = timeUpdate;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getTimeCreate() {
		return timeCreate;
	}

	public long getTimeUpdate() {
		return timeUpdate;
	}

	public String getFormatCreate() {
		return formatDate(timeCreate);
	}

	public String getFormatUpdate() {
		return formatDate(timeUpdate);
	}

	public String formatDate(Long time) {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(time);
	}

	public Map<String, String> toMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("id", Integer.toString(id));
		map.put("name", name);
		map.put("amount", Integer.toString(amount));
		map.put("timeCreate", Long.toString(timeCreate));
		map.put("timeUpdate", Long.toString(timeUpdate));
		return map;
	}

	@Override
	public String toString() {
		return "Customer ( Id=" + id + ", Name=" + name + ", Amount=" + amount + ", timeCreate=" + getFormatCreate()
				+ ", timeUpdate=" + getFormatUpdate() + ")";
	}

}
