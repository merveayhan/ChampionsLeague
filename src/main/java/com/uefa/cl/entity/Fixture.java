package com.uefa.cl.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.uefa.cl.framework.abstracts.AbstractEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Fixture extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	private LocalDateTime matchDate;

	private Integer homeTeamGoal;
	private Integer guestTeamGoal;

	@ManyToOne(fetch = FetchType.LAZY)
	private Team homeTeam;

	@ManyToOne(fetch = FetchType.LAZY)
	private Team guestTeam;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Group group;


}
