package com.uefa.cl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uefa.cl.dao.FixtureDao;
import com.uefa.cl.entity.Fixture;
import com.uefa.cl.entity.Group;
import com.uefa.cl.framework.abstracts.AbstractService;


@Service
public class FixtureService extends AbstractService<Fixture> {
	
	@Autowired private GroupService groupService;
	
	@Autowired private FixtureDao dao;

	public List<Fixture> getAllFixtures() {
		return dao.findAll();
	}

	public Fixture findByGroupName(String groupName) throws Exception{
		Group group = groupService.findByGroupName(groupName);
		if(group!=null) {
			return dao.findByGroup(group);	
		}else {
			throw new Exception(groupName + " isimli grup bulunamadı!");
		}
		
	}

}
