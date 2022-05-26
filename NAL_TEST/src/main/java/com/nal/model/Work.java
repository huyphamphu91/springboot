package com.nal.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name = "work")
public class Work {
	
	public enum Status {
		Planning, Doing, Complete;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "work_name")
	private String workName;
	@Column(name = "starting_date")
	private Date startingDate;
	@Column(name = "end_date")
	private Date endDate;
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date")
	private Date updateDate;
	public Work() {
	}
	public Work(String workName, Date startingDate, Date endDate, Status status) {
		this.workName = workName;
		this.startingDate = startingDate;
		this.endDate = endDate;
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	public Date getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public void setId(long id) {
		this.id = id;
	}

}
