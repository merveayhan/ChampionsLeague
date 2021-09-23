package com.uefa.cl.dto;


import com.uefa.cl.framework.abstracts.AbstractDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamDto extends AbstractDto {
    private static final long serialVersionUID = 1L;

    private String name;
    private String code;
    private String countryCode;
    private String countryName;
    
}
