package com.ua.robot.service;

import com.ua.robot.domain.City;
import com.ua.robot.dto.CityDto;
import com.ua.robot.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public List<CityDto> findAllCities() {
        List<City> cities = cityRepository.findAll();
        return cities.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public Optional<City> findCityById(Long id) {
        return cityRepository.findById(id);
    }

    public void saveCity(City city) {
        cityRepository.save(city);
    }

    private CityDto mapToDto(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .population(city.getPopulation())
                .country(city.getCountry().getName())
                .build();
    }
}