package com.backend.springboot.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.NotNull;

@Document("departament")
public class Departament {
	@Id
	private String _id;
	private String name;
	private String cod;
	private String ubigeo;
	private String inei;
	
	@NotNull
	@DBRef
	private StateType stateType_id;
	
	@NotNull
	@DBRef
	private Country country_id;
	
	@CreatedDate
	@Field("created_at")
	private LocalDateTime createdAt;
	
	@LastModifiedDate
	@Field("updated_at")
	private LocalDateTime updatedAt;
	
	public Departament() {
		if(this.cod == null) {
			this.cod = UUID.randomUUID().toString().replace("-", "").toUpperCase();			
		}
	}

	public Departament(String _id, String name, String cod, String ubigeo, String inei, LocalDateTime createdAt,
			LocalDateTime updatedAt, @NotNull StateType stateType_id, @NotNull Country country_id) {
		super();
		this._id = _id;
		this.name = name;
		this.cod = cod;
		this.ubigeo = ubigeo;
		this.inei = inei;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.stateType_id = stateType_id;
		this.country_id = country_id;
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

	public String getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}

	public String getInei() {
		return inei;
	}

	public void setInei(String inei) {
		this.inei = inei;
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

	public StateType getStateType_id() {
		return stateType_id;
	}

	public void setStateType_id(StateType stateType_id) {
		this.stateType_id = stateType_id;
	}

	public Country getCountry_id() {
		return country_id;
	}

	public void setCountry_id(Country country_id) {
		this.country_id = country_id;
	}

	@Override
	public String toString() {
		return "Departament [_id=" + _id + ", name=" + name + ", cod=" + cod + ", ubigeo=" + ubigeo + ", inei=" + inei
				+ ", stateType_id=" + stateType_id + ", country_id=" + country_id + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
	
}
