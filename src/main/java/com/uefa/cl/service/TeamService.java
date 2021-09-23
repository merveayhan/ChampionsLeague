package com.uefa.cl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uefa.cl.dao.TeamDao;
import com.uefa.cl.entity.Team;
import com.uefa.cl.framework.abstracts.AbstractService;


@Service
public class TeamService extends AbstractService<Team> {

    @Autowired private TeamDao dao;



}
