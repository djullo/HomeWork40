package com.ua.robot.controller;

import com.ua.robot.domain.City;
import com.ua.robot.domain.Country;
import com.ua.robot.dto.CountryDto;
import com.ua.robot.service.CityService;
import com.ua.robot.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;
    private final CityService cityService;

    @GetMapping
    public List<CountryDto> getCountries() {
        return countryService.findAllCountries();
    }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable("id") Long id) {
        return countryService.findCountryById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));
    }

    @PostMapping
    public void createCountry(@RequestBody Country country) {
        countryService.saveCountry(country);
    }
}