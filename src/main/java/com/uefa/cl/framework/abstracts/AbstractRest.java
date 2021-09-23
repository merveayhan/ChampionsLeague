package com.uefa.cl.framework.abstracts;

import com.uefa.cl.framework.generic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;


public abstract class AbstractRest<E extends GenericEntity, D extends GenericDto> implements GenericRest<E, D> {

	@Autowired protected GenericService<E> service;
	@Autowired protected GenericMapper<E, D> map;

//	@GetMapping("/{id}")
//	public ResponseEntity<D> get(@PathVariable Long id) throws Exception {
//		E entity = service.getById(id);
//		return new ResponseEntity<D>(map.map(entity), HttpStatus.OK);
//	}
//
	@GetMapping("/new")
	public ResponseEntity<D> actNew() throws Exception {
		E entity = service.actNew();
		return new ResponseEntity<>(map.map(entity), HttpStatus.OK);
	}
//
//	@PostMapping
//	public ResponseEntity<D> save(@RequestBody D dto) throws Exception {
//		E entity = service.save(map.unMap(dto));
//		return new ResponseEntity<D>(map.map(entity), HttpStatus.CREATED);
//	}
//
//	@DeleteMapping("/{id}")
//	public ResponseEntity<SimpleResponse> deleteById(@PathVariable Long id) throws Exception {
//		service.deleteById(id);
//		return new ResponseEntity<>(new SimpleResponse(HttpStatus.OK.toString()), HttpStatus.OK);
//	}


}
