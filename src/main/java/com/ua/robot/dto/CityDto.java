package com.ua.robot.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityDto {

    private Long id;
    private String name;
    private int population;
    private String country;
}