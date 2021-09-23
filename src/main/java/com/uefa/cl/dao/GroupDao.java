package com.uefa.cl.dao;

import org.springframework.stereotype.Repository;

import com.uefa.cl.entity.Group;
import com.uefa.cl.framework.generic.GenericDao;


@Repository
public interface GroupDao extends GenericDao<Group> {

	Group findByName(String name);


}
