package com.ua.robot.controller;

import com.ua.robot.domain.City;
import com.ua.robot.dto.CityDto;
import com.ua.robot.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public List<CityDto> getCities() {
        return cityService.findAllCities();
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable("id") Long id) {
        return cityService.findCityById(id)
                .orElseThrow(() -> new RuntimeException("City not found"));
    }

    @PostMapping
    public void createCity(@RequestBody City city) {
        cityService.saveCity(city);
    }
}
