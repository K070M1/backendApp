package com.backend.springboot.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("stateType")
public class StateType {
	
	@Id
	private String _id;
	
	private String name;
	
	private String cod;
	
	@CreatedDate
	@Field("created_at")
	private LocalDateTime createdAt;
	
	@LastModifiedDate
	@Field("updated_at")
	private LocalDateTime updatedAt;
	
	
	
	public StateType() {
		if(this.cod == null) {
			this.cod = UUID.randomUUID().toString().replace("-", "").toUpperCase();			
		}
	}
	
	public StateType(String _id, String name, String cod, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this._id = _id;
		this.name = name;
		this.cod = cod;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



	public String get_id() {
		return _id;
	}



	public void set_id(String _id) {
		this._id = _id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCod() {
		return cod;
	}



	public void setCod(String cod) {
		this.cod = cod;
	}



	public LocalDateTime getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}



	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}



	@Override
	public String toString() {
		return "StateType [_id=" + _id + ", name=" + name + ", cod=" + cod + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}
	
	
}
