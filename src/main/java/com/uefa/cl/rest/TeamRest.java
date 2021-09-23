package com.uefa.cl.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uefa.cl.dto.TeamDto;
import com.uefa.cl.entity.Team;
import com.uefa.cl.framework.abstracts.AbstractRest;
import com.uefa.cl.service.TeamService;

@RestController
@RequestMapping("/team")
public class TeamRest extends AbstractRest<Team, TeamDto> {
	
    @Autowired private TeamService service;
    
    

}
