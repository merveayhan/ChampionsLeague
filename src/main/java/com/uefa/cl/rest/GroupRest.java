package com.uefa.cl.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uefa.cl.dto.GroupDto;
import com.uefa.cl.entity.Group;
import com.uefa.cl.framework.abstracts.AbstractRest;
import com.uefa.cl.service.GroupService;

@RestController
@RequestMapping("/group")
public class GroupRest extends AbstractRest<Group, GroupDto> {
    @Autowired private GroupService service;
    
    @GetMapping("/distributionPotName")
    public ResponseEntity<List<GroupDto>> getAllPots(@RequestParam String potName) throws Exception {
       List<Group> pots = service.distributionPotName(potName);
        return new ResponseEntity<List<GroupDto>>(map.mapAll(pots), HttpStatus.OK);
    }
    

}
