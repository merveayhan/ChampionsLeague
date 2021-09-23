package com.uefa.cl.dto;

import java.time.LocalDateTime;

import com.uefa.cl.framework.abstracts.AbstractDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FixtureDto extends AbstractDto {
	private static final long serialVersionUID = 1L;

	private LocalDateTime matchDate;

	private Integer homeTeamGoal;
	private Integer guestTeamGoal;

	private TeamDto homeTeam;
	private TeamDto guestTeam;
	private GroupDto group;

}
