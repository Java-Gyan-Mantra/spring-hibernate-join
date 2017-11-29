package com.spring.hbm.mapping.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.hbm.mapping.api.model.Address;
import com.spring.hbm.mapping.api.model.Business;
import com.spring.hbm.mapping.api.model.User;
import com.spring.hbm.mapping.api.model.Veichle;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown=true)
public class UserRequest {
	private User user;
	private List<Business> business;
	private Address address;
	private Veichle veichle;
}
