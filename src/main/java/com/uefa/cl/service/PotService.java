package com.uefa.cl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uefa.cl.dao.PotDao;
import com.uefa.cl.entity.Pot;
import com.uefa.cl.framework.abstracts.AbstractService;


@Service
public class PotService extends AbstractService<Pot> {
	
	 @Autowired private PotDao dao;

	public List<Pot> getAllPots() {
		return dao.findAll();
	}

	public Pot findByPotName(String name) {
		return dao.findByName(name);
	}

}
