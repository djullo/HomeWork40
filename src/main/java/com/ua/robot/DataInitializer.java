package com.ua.robot;

import com.ua.robot.domain.City;
import com.ua.robot.domain.Country;
import com.ua.robot.service.CityService;
import com.ua.robot.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
public class DataInitializer {
    private final CityService cityService;
    private final CountryService countryService;

    public DataInitializer(CityService cityService, CountryService countryService) {
        this.cityService = cityService;
        this.countryService = countryService;
    }

    @PostConstruct
    public void init() {
        Country country1 = Country.builder().name("Україна").build();
        Country country2 = Country.builder().name("США").build();

        countryService.saveCountry(country1);
        countryService.saveCountry(country2);

        City city1 = City.builder().name("Київ").population(2800000).country(country1).build();
        City city2 = City.builder().name("Львів").population(721301).country(country1).build();
        City city3 = City.builder().name("Нью-Йорк").population(8537673).country(country2).build();
        City city4 = City.builder().name("Лос-Анджелес").population(3979576).country(country2).build();

        cityService.saveCity(city1);
        cityService.saveCity(city2);
        cityService.saveCity(city3);
        cityService.saveCity(city4);
    }
}