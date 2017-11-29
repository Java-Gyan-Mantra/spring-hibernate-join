package com.spring.hbm.mapping.api.repository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hbm.mapping.api.model.User;

@Repository
@Transactional
public class UserMappingRepository {
	@Autowired
	private SessionFactory factory;

	public void SaveUser(User user) {
		getSession().save(user);
	}

	@SuppressWarnings("unchecked")
	/* Fetching data using Native SQL Query without using join */
	public List<Object> getUserAndVeichleInfo() {
		return getSession()
				.createSQLQuery(
						"select u.userid,u.name,u.profession ,v.veichleId,v.veichlename,v.color from associationmapping.user1_tb u ,associationmapping.veichle1_tb v")
				.list();
	}

	// query for many to one join
	@SuppressWarnings("unchecked")
	public Map<String, Object> getUserVeichleInfo() {
		Map<String, Object> map = new HashMap<>();
		String SQL = "select v.veichleId ,v.veichleName,v.color ,u.userid,u.name from User u join u.veichle v";
		List<Object> list = getSession().createQuery(SQL).list();
		Iterator<Object> itr = list.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			map.put("VeichleId", obj[0]);
			map.put("VeichleName", obj[1]);
			map.put("Veichle-color", obj[2]);
			map.put("userId", obj[3]);
			map.put("name", obj[4]);
		}
		return map;
	}

	// query for one to many join
	@SuppressWarnings("unchecked")
	public Map<String, Object> getUserBusinessInfo() {
		Map<String, Object> map = new HashMap<>();
		String SQL = "select b.businessId,b.businessType,b.turnOver,u.userid,u.name from User u join u.business b";
		Iterator<Object> itr = getSession().createQuery(SQL).list().iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			map.put("BusinessId", obj[0]);
			map.put("BusinessName", obj[1]);
			map.put("TC", obj[2]);
			map.put("userId", obj[3]);
			map.put("name", obj[4]);
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getUserAllMapingInfo() {
		Map<String, Object> map = new LinkedHashMap<>();
		String SQL = "select b.businessId,b.businessType,b.turnOver,v.veichleId ,v.veichleName,v.color, a.zip,a.city,a.state ,u.userid,u.name from User u join u.business b  join  u.address a  join  u.veichle v";
		Iterator<Object> itr = getSession().createQuery(SQL).list().iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			map.put("BusinessId", obj[0]);
			map.put("BusinessName", obj[1]);
			map.put("TC", obj[2]);
			map.put("VeichleId", obj[3]);
			map.put("VeichleName", obj[4]);
			map.put("Veichle-color", obj[5]);
			map.put("Zip", obj[6]);
			map.put("City", obj[7]);
			map.put("State", obj[8]);
			map.put("userId", obj[9]);
			map.put("name", obj[10]);
		}
		return map;
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}
}
