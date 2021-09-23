package com.uefa.cl.framework.generic;

import org.springframework.http.ResponseEntity;

public interface GenericRest<E extends GenericEntity, D extends GenericDto> {

//	ResponseEntity<D> get(@PathVariable Long id) throws Exception;
	ResponseEntity<D> actNew() throws Exception;
//	ResponseEntity<D> save(@RequestBody D dto) throws Exception;
}
