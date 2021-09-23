package com.uefa.cl.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.uefa.cl.framework.abstracts.AbstractEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pot extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pot")
    private List<Team> teams = new ArrayList<>();
}
