package com.infoobjects.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity(name = "Teacher")
//@Table(name = "teacher")
public class Teacher {
	@Id
	@Column(name = "id", unique = true, insertable = true)
	private Integer id;
	@NotBlank
	@Column(name = "name", updatable = true, insertable = true)
	private String name;

	@NotBlank
	@Column(name = "salary", updatable = true, insertable = true)
	private Integer salary;
	@Column(name = "timeCreate", updatable = false)
	private Long timeCreate;
	@Column(name = "timeUpdate", updatable = true)
	private Long timeUpdate;

	public Teacher() {
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public long getTimeCreate() {
		return timeCreate;
	}

	public void setTimeCreate(long timeCreate) {
		this.timeCreate = timeCreate;
	}

	public long getTimeUpdate() {
		return timeUpdate;
	}

	public void setTimeUpdate(long timeUpdate) {
		this.timeUpdate = timeUpdate;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", salary=" + salary + ", timeCreate=" + timeCreate
				+ ", timeUpdate=" + timeUpdate + "]";
	}

//	public Map<String, String> toMap() {
//		Map<String, String> map = new LinkedHashMap<String, String>();
//		map.put("id", Integer.toString(id));
//		map.put("name", name);
//		map.put("amount", Integer.toString(amount));
//		map.put("timeCreate", Long.toString(timeCreate));
//		map.put("timeUpdate", Long.toString(timeUpdate));
//		return map;
//	}

}
