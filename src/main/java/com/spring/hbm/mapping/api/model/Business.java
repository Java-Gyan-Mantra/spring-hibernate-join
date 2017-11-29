package com.spring.hbm.mapping.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "BUSINESS1_TB")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Business {
	@Id
	private int businessId;
	private String businessType;
	private long turnOver;

}
