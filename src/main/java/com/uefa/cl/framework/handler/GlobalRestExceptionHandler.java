package com.uefa.cl.framework.handler;

import javax.naming.NoPermissionException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {



	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleGenericException(Exception e, WebRequest request) {
		e.printStackTrace();
		ResponseEntity<Object> responseEntity = customExceptionControl(e);
		if (responseEntity != null) {
			return responseEntity;
		}
		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	private ResponseEntity<Object> customExceptionControl(Exception e) {
		 if (e instanceof NoPermissionException) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.FORBIDDEN);
		}  else if (e instanceof DataIntegrityViolationException) {
			return getRootCause(e);
		} else if (e instanceof InvalidDataAccessResourceUsageException) {
			return getRootCause(e);
		}  else if (e instanceof SQLGrammarException) {
			return getRootCause(e);
		} else if (e instanceof PersistenceException) {
			return getRootCause(e);
		}
		return null;
	}

	private ResponseEntity<Object> getRootCause(Throwable throwable) {
		String message = ExceptionUtils.getRootCause(throwable).getMessage();
		return new ResponseEntity<Object>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}