package com.uefa.cl.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.uefa.cl.framework.abstracts.AbstractEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Team extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	private String name;
	private String code;
	private String countryCode;
	private String countryName;

	@ManyToOne(fetch = FetchType.LAZY)
	private Pot pot;

	@ManyToOne(fetch = FetchType.LAZY)
	private Group group;

}
