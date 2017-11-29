package com.spring.hbm.mapping.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "USER1_TB")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
	@Id
	@GeneratedValue
	private int userid;
	private String name;
	private String profession;

	@OneToMany(targetEntity = Business.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_business_fk", referencedColumnName = "userid")
	private List<Business> business;

	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_address_fk")
	private Address address;

	@ManyToOne(targetEntity = Veichle.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_veichle_fk")
	private Veichle veichle;
}
