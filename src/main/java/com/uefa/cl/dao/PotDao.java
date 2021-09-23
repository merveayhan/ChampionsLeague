package com.uefa.cl.dao;

import org.springframework.stereotype.Repository;

import com.uefa.cl.entity.Pot;
import com.uefa.cl.framework.generic.GenericDao;


@Repository
public interface PotDao extends GenericDao<Pot> {

	Pot findByName(String name);

	

}
