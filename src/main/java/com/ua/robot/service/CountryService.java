package com.ua.robot.service;

import com.ua.robot.domain.City;
import com.ua.robot.domain.Country;
import com.ua.robot.dto.CountryDto;
import com.ua.robot.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public List<CountryDto> findAllCountries() {
        List<Country> countries = (List<Country>) countryRepository.findAll();
        return countries.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public Optional<Country> findCountryById(Long id) {
        return countryRepository.findById(id);
    }

    public void saveCountry(Country country) {
        countryRepository.save(country);
    }

    private CountryDto mapToDto(Country country) {
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .cities(country.getCities().stream()
                        .map(City::getName)
                        .collect(Collectors.toList()))
                .build();
    }
}