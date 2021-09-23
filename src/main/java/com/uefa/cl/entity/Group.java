package com.uefa.cl.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uefa.cl.framework.abstracts.AbstractEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@Table(name = "groups", uniqueConstraints = { @UniqueConstraint(columnNames = { "id","teamOrder" })})
//@Table(name = "groups")
public class Group extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	private String name;
	private Integer teamOrder = 0;

	private Integer played = 0; // oynanan mac
	private Integer won = 0; // galibiyet
	private Integer drawn = 0; // beraberlik
	private Integer lost = 0; // malubiyet
	private Integer goalScored = 0; // attıgi gol
	private Integer goalConceded = 0; // yedigi gol
	private Integer goalDifference = 0; // yedigi gol
	private Integer points = 0; // yedigi gol

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pot")
	private List<Team> teams = new ArrayList<>();
}
