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

@Document("province")
public class Province {
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
	
	@NotNull
	@DBRef
	private Departament departament_id;
	
	@CreatedDate
	@Field("created_at")
	private LocalDateTime createdAt;
	
	@LastModifiedDate
	@Field("updated_at")
	private LocalDateTime updatedAt;
	
	public Province() {
		if(this.cod == null) {
			this.cod = UUID.randomUUID().toString().replace("-", "").toUpperCase();			
		}
	}

	public Province(String _id, String name, String cod, String ubigeo, String inei, @NotNull StateType stateType_id,
			@NotNull Country country_id, @NotNull Departament departament_id, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this._id = _id;
		this.name = name;
		this.cod = cod;
		this.ubigeo = ubigeo;
		this.inei = inei;
		this.stateType_id = stateType_id;
		this.country_id = country_id;
		this.departament_id = departament_id;
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

	public Departament getDepartament_id() {
		return departament_id;
	}

	public void setDepartament_id(Departament departament_id) {
		this.departament_id = departament_id;
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
		return "Province [_id=" + _id + ", name=" + name + ", cod=" + cod + ", ubigeo=" + ubigeo + ", inei=" + inei
				+ ", stateType_id=" + stateType_id + ", country_id=" + country_id + ", departament_id=" + departament_id
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
}
