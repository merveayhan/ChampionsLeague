package com.uefa.cl.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uefa.cl.dto.FixtureDto;
import com.uefa.cl.entity.Fixture;
import com.uefa.cl.framework.abstracts.AbstractRest;
import com.uefa.cl.service.FixtureService;

@RestController
@RequestMapping("/fixture")
public class FixtureRest extends AbstractRest<Fixture, FixtureDto> {

	@Autowired private FixtureService service;

	@GetMapping("/getAllFixtures")
	public ResponseEntity<List<FixtureDto>> getAllFixtures() throws Exception {
		List<Fixture> fixtures = service.getAllFixtures();
		return new ResponseEntity<List<FixtureDto>>(map.mapAll(fixtures), HttpStatus.OK);
	}

	@GetMapping("/findByGroupName")
	public ResponseEntity<FixtureDto> findByGroupName(@RequestParam String groupName) throws Exception {
		Fixture fixture = service.findByGroupName(groupName);
		return new ResponseEntity<FixtureDto>(map.map(fixture), HttpStatus.OK);
	}

}
