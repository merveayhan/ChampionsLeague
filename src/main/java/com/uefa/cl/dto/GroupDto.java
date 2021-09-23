package com.uefa.cl.dto;

import java.util.List;

import com.uefa.cl.framework.abstracts.AbstractDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupDto extends AbstractDto {
	private static final long serialVersionUID = 1L;

	private String name;
	private Integer fieldOrder;

	private Integer played;
	private Integer won;
	private Integer drawn;
	private Integer lost;
	private Integer goalScored;
	private Integer goalConceded;
	private Integer goalDifference;
	private Integer points;

	private List<TeamDto> teams;

}
