package com.uefa.cl.dto;


import java.util.List;

import com.uefa.cl.framework.abstracts.AbstractDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PotDto extends AbstractDto {
    private static final long serialVersionUID = 1L;

    private String name;
    
    private List<TeamDto> teams;

}
