package com.ua.robot.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CountryDto {

    private Long id;
    private String name;
    private List<String> cities;
}