package com.uefa.cl.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uefa.cl.dto.PotDto;
import com.uefa.cl.entity.Pot;
import com.uefa.cl.framework.abstracts.AbstractRest;
import com.uefa.cl.service.PotService;

@RestController
@RequestMapping("/pot")
public class PotRest extends AbstractRest<Pot, PotDto> {
    @Autowired private PotService service;
    
    @GetMapping("/getAllPots")
    public ResponseEntity<List<PotDto>> getAllPots() throws Exception {
       List<Pot> pots = service.getAllPots();
        return new ResponseEntity<List<PotDto>>(map.mapAll(pots), HttpStatus.OK);
    }
    
    @GetMapping("/findByPotName")
    public ResponseEntity<PotDto> findByPotName(@RequestParam String name) throws Exception {
       Pot pot = service.findByPotName(name);
        return new ResponseEntity<PotDto>(map.map(pot), HttpStatus.OK);
    }

}
