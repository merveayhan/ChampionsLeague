package com.uefa.cl.dao;

import org.springframework.stereotype.Repository;

import com.uefa.cl.entity.Fixture;
import com.uefa.cl.entity.Group;
import com.uefa.cl.framework.generic.GenericDao;


@Repository
public interface FixtureDao extends GenericDao<Fixture> {
	

	Fixture findByGroup(Group group);

}
