package com.uefa.cl.framework.abstracts;

import java.time.LocalDateTime;

import com.uefa.cl.framework.generic.GenericDto;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class AbstractDto implements GenericDto {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private LocalDateTime createDate;
}
